package com.airbnb.airbnb.services.authentication;

import com.airbnb.airbnb.dto.authentication.AuthenticationRequest;
import com.airbnb.airbnb.dto.authentication.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse signUp(AuthenticationRequest authenticationRequest);

    AuthenticationResponse signIn(String email, String password);
}
