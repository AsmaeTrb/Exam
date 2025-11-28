package org.example.equipes_security.Controller;

import org.example.equipes_security.Service.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {
    private PasswordEncoder passwordEncoder;
    private UserDetails userDetails;
    public SecurityController(PasswordEncoder passwordEncoder, UserDetails userDetails) {
        this.passwordEncoder = passwordEncoder;
        this.userDetails = userDetails;
    }
}
