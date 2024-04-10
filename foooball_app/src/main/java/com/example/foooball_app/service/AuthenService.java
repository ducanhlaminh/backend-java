package com.example.foooball_app.service;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.enums.Role;
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

    public User signUpBtvService(AuthenRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole_enum(Role.BTV);
        return UserRepository.save(user);
    }
    public User signUpSponsorService(AuthenRequest request){
        boolean exitUser = UserRepository.existsUserByUsername(request.getUsername());
        ApiResponse<User> apiResponse = new ApiResponse<>();
        User user = new User();
        if(exitUser){
            throw new AppError(ErrorCode.USER_EXISTED);
        }else{

            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setRole_enum(Role.SPONSOR);
        }
        return  UserRepository.save(user);
    }
    public User loginService(AuthenRequest request){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User user = UserRepository.findByUsername(request.getUsername()).orElseThrow(()-> new AppError(ErrorCode.USER_EXISTED));
        boolean authenticated = passwordEncoder.matches(request.getPassword(),
                user.getPassword());
        if (!authenticated)
            throw new AppError(ErrorCode.LOGIN_FAIL);

        String token = generateToken(user);
        user.setToken(token);
        return user;
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
                .claim("scope",Role.BTV)
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
