package com.soar.springsecurity.spring.security;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        log.info("User="+user.toString());

        Role role;
        if(user == null){
            throw new UsernameNotFoundException("User Not Found!");
        }else {
            role = roleRepository.getRoleById(user.getRoleId());
        }
        return new CustomUserDetails(user, role);
    }
}
