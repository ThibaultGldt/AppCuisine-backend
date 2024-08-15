package com.app.Cuisine.service.auth;

import com.app.Cuisine.dto.auth.LoginUserDTO;
import com.app.Cuisine.dto.auth.RegisterUserDto;
import com.app.Cuisine.entity.User;
import com.app.Cuisine.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto registerDTO) {
        User user = new User();
        user.setUsername(registerDTO.username());
        user.setEmail(registerDTO.email());
        user.setPassword(passwordEncoder.encode(registerDTO.password()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.login(),
                        loginDTO.password()
                )
        );

        return userRepository.findByEmail(loginDTO.login()).orElseThrow();
    }
}
