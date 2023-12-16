package com.airbnb.airbnb.dto.hello;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HelloResponse {
    private String message;
}
