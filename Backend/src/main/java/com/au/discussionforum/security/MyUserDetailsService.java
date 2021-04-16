
package com.au.discussionforum.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.UserRepository;
import com.au.discussionforum.model.User;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository secureUserRepository;
    static Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);

    public MyUserDetailsService(UserRepository secureUserRepository) {
    	log.info("[ENTER] [MyUserDetailsService] contructor");
        this.secureUserRepository = secureUserRepository;
        log.info("[EXIT] [MyUserDetailsService] contructor");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	log.info("[ENTER] [MyUserDetailsService] loadUserByUsername"+userName);
        final User user = secureUserRepository.findByUsername(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + userName + "' not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(userName)
                .password(user.getPassword())
                .authorities(user.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}