package com.springsecutiry.fiap.modules.ativos.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    String getUserInfo(@AuthenticationPrincipal OidcUser principal) {
        return String.format("""              
                <h3>Principal: %s</h3>
                <h3>Email: %s</h3>
                <h3>Authorities: %s</h3>
                <h3>Token JWT: %s</h3>
                """, principal, principal.getAttribute("email"), principal.getAuthorities(),
                principal.getIdToken().getTokenValue());
    }
}