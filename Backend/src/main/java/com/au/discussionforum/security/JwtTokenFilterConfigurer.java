package com.au.discussionforum.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

	@Autowired
    private IJwtTokenProviderService jwtTokenProviderService;
    
    static Logger log = LoggerFactory.getLogger(JwtTokenFilterConfigurer.class);

    public JwtTokenFilterConfigurer(IJwtTokenProviderService jwtTokenProviderService) {
    	log.info("[ENTER] [JwtTokenFilterConfigurer] contructor"+jwtTokenProviderService.hashCode());
        this.jwtTokenProviderService = jwtTokenProviderService;
        log.info("[EXIT] [JwtTokenFilterConfigurer] contructor"+jwtTokenProviderService.hashCode());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	log.info("[ENTER] [JwtTokenFilterConfigurer] configure");
        JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProviderService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        log.info("[EXIT] [JwtTokenFilterConfigurer] configure");
    }

}