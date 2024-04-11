package com.example.foooball_app.dto.response;

import com.example.foooball_app.enums.Role;

public class ResponseLogin {

    private String username;

    private Role role_enum;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole_enum() {
        return role_enum;
    }

    public void setRole_enum(Role role_enum) {
        this.role_enum = role_enum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
