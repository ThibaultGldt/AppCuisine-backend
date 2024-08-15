package com.app.Cuisine.entity.auth;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

    public LoginResponse() {}
}
