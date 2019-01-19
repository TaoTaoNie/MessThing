package com.example.n2n.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author leetHuam
 * @version 1.0
 */
@RestController
public class HelloController {
    @GetMapping
    public String say(@RequestParam(required = false, defaultValue = "") String name) {
        return name.equals("") ? "Hey!" : "Hey " + name + "!";
    }
}
