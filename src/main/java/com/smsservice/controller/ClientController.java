package com.smsservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ClientController {
    @GetMapping("/")
    public String create() {
        return "create";
    }
}
