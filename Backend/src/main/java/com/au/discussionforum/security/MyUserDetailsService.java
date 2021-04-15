
package com.au.discussionforum.security;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.au.discussionforum.dao.UserRepository;
import com.au.discussionforum.model.User;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository secureUserRepository;

    public MyUserDetailsService(UserRepository secureUserRepository) {
        this.secureUserRepository = secureUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
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