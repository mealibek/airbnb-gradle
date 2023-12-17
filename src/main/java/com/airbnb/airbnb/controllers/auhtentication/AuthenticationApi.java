package com.airbnb.airbnb.controllers.auhtentication;

import com.airbnb.airbnb.dto.authentication.AuthenticationRequest;
import com.airbnb.airbnb.dto.authentication.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/api/auth")
public interface AuthenticationApi {

    @PostMapping("/sing-up")
    @ResponseStatus(HttpStatus.CREATED)
    AuthenticationResponse signUp(AuthenticationRequest authenticationRequest);

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    AuthenticationResponse signUp(String email, String password);
}
