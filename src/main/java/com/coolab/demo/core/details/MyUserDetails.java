package com.coolab.demo.core.details;

import com.coolab.demo.common.UserType;
import com.coolab.demo.entities.concretes.Role;
import com.coolab.demo.entities.concretes.User;
import com.coolab.demo.entities.concretes.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetails implements UserDetails {
    private User user;

    public MyUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserType> roles = Collections.singleton(user.getRole());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (UserType role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
