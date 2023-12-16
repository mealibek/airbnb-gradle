package com.airbnb.airbnb.controllers.hello;

import com.airbnb.airbnb.dto.hello.HelloResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController implements HelloApi {

    @Override
    public HelloResponse hello(String name) {
        return HelloResponse.builder()
                .message("Hello " + name)
                .build();
    }
}
