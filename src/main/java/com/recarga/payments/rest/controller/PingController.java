
package com.recarga.payments.rest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class PingController {
    @GetMapping
    public String ping() {
        return "pong";
    }
}
