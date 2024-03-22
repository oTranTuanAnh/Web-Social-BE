package com.websocial.controller;

import com.websocial.config.service.JwtResponse;
import com.websocial.config.service.JwtService;
import com.websocial.config.service.UserService;
import com.websocial.model.appUser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;
    public static Long current_id;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(user.getUsername());
        JwtResponse a = new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities());
        current_id = currentUser.getId();
        System.out.println(current_id);
        return ResponseEntity.ok(a);
//        return ResponseEntity.ok(new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
}