package ru.ivanov.ecommerceplatformproject.userservice.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class JwtPrincipalDetails implements UserDetails {
    @Getter
    private final UUID principalId;
    private final List<GrantedAuthority> roles;

    public JwtPrincipalDetails(UUID principalId, List<GrantedAuthority> roles) {
        this.principalId = principalId;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }
}