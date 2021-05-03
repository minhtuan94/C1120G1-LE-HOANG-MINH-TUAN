package com.casestudy4.services.impl;

import com.casestudy4.entity.UserRole;
import com.casestudy4.repository.UserRepository;
import com.casestudy4.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.casestudy4.entity.User user = this.userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        System.out.println("Found User: " + user);

        // [ROLE_USER, ROLE_ADMIN,..]
        UserRole userRole = this.userRoleRepository.findByUser(user);

        List<GrantedAuthority> grantList = new ArrayList<>();
        if (userRole != null) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getRole().getName());
            grantList.add(grantedAuthority);
        }

        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);

        System.out.println(userDetails.getAuthorities());

        return userDetails;
    }
}