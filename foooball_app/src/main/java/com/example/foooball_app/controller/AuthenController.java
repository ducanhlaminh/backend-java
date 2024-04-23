package com.example.foooball_app.controller;
import com.example.foooball_app.dto.request.AuthenRequest;
import com.example.foooball_app.dto.response.ApiResponse;
import com.example.foooball_app.dto.response.ResponseLogin;

import com.example.foooball_app.entity.Sponsor;
import com.example.foooball_app.entity.User;
import com.example.foooball_app.service.AuthenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthenController {
    @Autowired
    private AuthenService AuthenService;
    @PostMapping("/sign-up/btv")
    ApiResponse<User> signUpBtvController(@RequestBody AuthenRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(AuthenService.signUpBtvService(request));
        return apiResponse;
    }
    @PostMapping("/sign-up/sponsor")
    ApiResponse signUpSponsorController(@RequestBody AuthenRequest request){
        ApiResponse<Sponsor> apiResponse = new ApiResponse<>();
        AuthenService.signUpSponsorService(request);
        apiResponse.setMessage( "Đăng ký thành cong");
        return apiResponse;
    }
    @PostMapping("/login")
    ApiResponse<ResponseLogin> loginController(@RequestBody AuthenRequest request) {
        ApiResponse<ResponseLogin> apiResponse = new ApiResponse<>();
        ResponseLogin ResponseLogin = new ResponseLogin();
        User user = AuthenService.loginService(request);
            ResponseLogin.setToken(user.getToken());
            ResponseLogin.setUsername(user.getUsername());
            ResponseLogin.setRole_enum(user.getRole_enum());
            apiResponse.setResult(ResponseLogin);
        return apiResponse;
    }
}
