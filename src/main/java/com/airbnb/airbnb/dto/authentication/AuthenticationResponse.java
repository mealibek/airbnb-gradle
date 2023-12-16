package com.airbnb.airbnb.dto.authentication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationResponse {
    private String email;

    private String token;
}
