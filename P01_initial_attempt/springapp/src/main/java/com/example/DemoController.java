package com.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping("/resource/{resourceId}")
    @PreAuthorize("hasRole('ROLE_my-app-admin') || hasRole('ROLE_my-app-user') && #resourceId == authentication.name")
    public Response getResource(@PathVariable String resourceId) {
        return new Response("Resource:" + resourceId + " USER:" + SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_my-app-user')")
    public Response user() {
        return new Response("HELLO USER:" + SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_my-app-admin')")
    public Response admin() {
        return new Response("HELLO ADMIN:" + SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

record Response(String message) {}
