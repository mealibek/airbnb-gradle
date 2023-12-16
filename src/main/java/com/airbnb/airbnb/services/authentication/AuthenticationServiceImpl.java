package com.airbnb.airbnb.services.authentication;

import com.airbnb.airbnb.config.security.jsonwebtoken.JWTAuthenticationService;
import com.airbnb.airbnb.dto.authentication.AuthenticationRequest;
import com.airbnb.airbnb.dto.authentication.AuthenticationResponse;
import com.airbnb.airbnb.enums.Role;
import com.airbnb.airbnb.models.User;
import com.airbnb.airbnb.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final JWTAuthenticationService jwtAuthenticationService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    @Override
    public AuthenticationResponse signUp(AuthenticationRequest authenticationRequest) {
        User user = User.builder()
                .email(authenticationRequest.getEmail())
                .password(authenticationRequest.getPassword())
                .role(Role.USER)
                .build();
        String encodedPass = passwordEncoder.encode(authenticationRequest.getPassword());
        user.setPassword(encodedPass);
        userRepository.save(user);
        return AuthenticationResponse
                .builder()
                .email(authenticationRequest.getEmail())
                .token(jwtAuthenticationService.generateToken(user))
                .build();
    }

    @Override
    public AuthenticationResponse signIn(String email, String password) {
        var user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new BadCredentialsException(
                        String.format("Email %s is not registered!", email)
                ));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        password
                )
        );
        var jwtToken = jwtAuthenticationService.generateToken(user);
        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .token(jwtToken)
                .build();
    }
}
