package com.azeka.promocityapi.com.azeka.promocityapi.service;

import com.azeka.promocityapi.com.azeka.promocityapi.model.AppUser;
import com.azeka.promocityapi.com.azeka.promocityapi.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public class UserDetailServiceImpl implements UserDetailsService {


    UserService userService;

    public UserDetailServiceImpl (UserService userService){
        this.userService=userService;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = userService.findUser(username);
        if (!appUser.isPresent()) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<UserRole> roles = appUser.get().getUserRoles();
        appUser.get().getUserRoles().forEach(userRole -> {
            authorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        });
        return new User(appUser.get().getMail(),appUser.get().getPassword(),authorities);
    }
}
