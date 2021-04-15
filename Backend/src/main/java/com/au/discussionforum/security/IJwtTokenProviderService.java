package com.au.discussionforum.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import com.au.discussionforum.model.Role;

public interface IJwtTokenProviderService {
    String createToken(String username, List<Role> roles);
    Authentication validateUserAndGetAuthentication(String token);
    String getUsername(String token);
    String parseToken(HttpServletRequest req);
    boolean validateToken(String token);

}
