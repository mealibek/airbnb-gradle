package com.airbnb.airbnb.controllers.hello;

import com.airbnb.airbnb.dto.hello.HelloResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/hello")
public interface HelloApi {

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    HelloResponse hello(@RequestParam(defaultValue = "World", required = false) String name);
}
