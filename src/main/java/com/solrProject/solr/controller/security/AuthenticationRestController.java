package com.solrProject.solr.controller.security;

import com.solrProject.solr.security.dto.AuthenticationRequestDto;
import com.solrProject.solr.security.dto.singin.UserSinginDto;
import com.solrProject.solr.security.jwt.util.JwtTokenProvider;
import com.solrProject.solr.security.model.Role;
import com.solrProject.solr.security.model.User;
import com.solrProject.solr.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/singup")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            String password = requestDto.getPassword();
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/singin")
    public ResponseEntity createUser(@RequestBody UserSinginDto user){
        if (user != null){
            User register = userService.register(user);
            return register != null ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/addRole")
    public ResponseEntity createRole(@RequestParam String role){
        if(role != null && !role.isEmpty()){
            Role role1 = userService.createRole(role);
            return role1 != null ? new ResponseEntity<>(role1, HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
