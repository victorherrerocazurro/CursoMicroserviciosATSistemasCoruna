package com.oauth.spring;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@PreAuthorize("#oauth2.hasScope('write')")
public class UserController {

    @RequestMapping("/")
    public Principal resource(Principal principal) {
        return principal;
    }

}
