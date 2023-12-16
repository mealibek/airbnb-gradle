package com.airbnb.airbnb.services.authentication;

import com.airbnb.airbnb.config.security.jsonwebtoken.JWTAuthenticationService;
import com.airbnb.airbnb.dto.authentication.AuthenticationRequest;
import com.airbnb.airbnb.dto.authentication.AuthenticationResponse;
import com.airbnb.airbnb.models.User;
import com.airbnb.airbnb.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final JWTAuthenticationService jwtAuthenticationService;

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest authenticationRequest) {
        User user = User.builder()
                .email(authenticationRequest.getEmail())
                .password(authenticationRequest.getPassword())
                .build();
        userRepository.save(user);
        return AuthenticationResponse
                .builder()
                .email(authenticationRequest.getEmail())
                .token(jwtAuthenticationService.generateToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse signIn(String email, String password) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("Not found"));
        return  AuthenticationResponse
                .builder()
                .email(user.getEmail())
                .token(jwtAuthenticationService.generateToken(user))
                .build();
    }
}
