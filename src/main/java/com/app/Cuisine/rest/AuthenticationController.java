package com.app.Cuisine.rest;

import com.app.Cuisine.dto.auth.LoginUserDTO;
import com.app.Cuisine.dto.auth.RegisterUserDto;
import com.app.Cuisine.entity.User;
import com.app.Cuisine.entity.auth.LoginResponse;
import com.app.Cuisine.service.auth.AuthenticationService;
import com.app.Cuisine.service.auth.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerDTO) {
        User registeredUser = authenticationService.signup(registerDTO);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginDTO) {
        User authenticatedUser = authenticationService.authenticate(loginDTO);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
