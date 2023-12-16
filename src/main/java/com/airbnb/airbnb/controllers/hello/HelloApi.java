package com.airbnb.airbnb.controllers.hello;

import com.airbnb.airbnb.dto.hello.HelloResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/hello")
public interface HelloApi {
    @GetMapping("")
    HelloResponse hello(@RequestParam(defaultValue = "World", required = false) String name);
}
