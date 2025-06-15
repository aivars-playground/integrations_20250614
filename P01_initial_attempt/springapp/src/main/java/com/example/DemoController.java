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
    public Response user() {
        return new Response("HELLO USER");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('my-app-admin')")
    public Response admin() {
        return new Response("HELLO ADMIN");
    }
}

record Response(String message) {}
