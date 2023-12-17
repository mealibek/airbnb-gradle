package com.airbnb.airbnb.controllers.bye;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/bye")
public interface ByeApi {

    @PostMapping
    String bye (String word);

}
