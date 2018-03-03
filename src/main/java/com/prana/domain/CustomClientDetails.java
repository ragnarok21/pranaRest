package com.prana.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomClientDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomClientDetails(Cliente clienteByUsername) {
        this.username = clienteByUsername.getUsername();
        this.password = clienteByUsername.getPassword();

        List<GrantedAuthority> auth = new ArrayList<>();
        for (Roles role : clienteByUsername.getRoles()) {
            auth.add(new SimpleGrantedAuthority(role.getNombre().toUpperCase()));
        }

        this.authorities = auth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }
}
