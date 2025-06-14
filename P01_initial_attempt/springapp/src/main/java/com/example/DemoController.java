package com.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('my-app-user')")
    public String user() {
        return "HELLO USER";
    }

    @GetMapping("/admin")
    public String admin() { return "HELLO ADMIN"; }
}
