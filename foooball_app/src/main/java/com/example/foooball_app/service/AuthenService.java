package com.example.foooball_app.service;
import com.example.foooball_app.exception.AppError;
import com.example.foooball_app.exception.ErrorCode;
import com.nimbusds.jose.JWSHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.foooball_app.dto.request.AuthenRequest;
import com.example.foooball_app.entity.User;
import com.example.foooball_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
@Service
@Slf4j
public class AuthenService {
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;


    @Autowired
    private UserRepository UserRepository;
    public User signUpService(AuthenRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return UserRepository.save(user);
    }
    public String loginService(AuthenRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = UserRepository.findByUsername(request.getUsername()).orElseThrow(()-> new AppError(ErrorCode.SPONSOR_UNEXISTED));
        boolean authenticated = passwordEncoder.matches(request.getPassword(),
                user.getPassword());
        if (!authenticated)
            throw new AppError(ErrorCode.SPONSOR_UNEXISTED);

        var token = generateToken(user);
        return token;
    }
    private String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issuer("football.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new RuntimeException(e);
        }
    }
}
