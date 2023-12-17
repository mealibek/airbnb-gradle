package com.airbnb.airbnb.controllers.bye;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ByeController implements ByeApi {

    @Override
    public String bye(String word) {
        return "Bye " + word;
    }
}
