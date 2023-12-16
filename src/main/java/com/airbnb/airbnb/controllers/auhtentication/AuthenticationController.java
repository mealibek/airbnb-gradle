package com.airbnb.airbnb.controllers.auhtentication;

import com.airbnb.airbnb.dto.authentication.AuthenticationRequest;
import com.airbnb.airbnb.dto.authentication.AuthenticationResponse;
import com.airbnb.airbnb.services.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthenticationController implements AuthenticationApi{

   private final AuthenticationService authenticationService;

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest authenticationRequest) {
        return authenticationService.signUp(authenticationRequest);
    }

    @Override
    public AuthenticationResponse signUp(String email, String password) {
        return authenticationService.signIn(email,password);
    }
}
