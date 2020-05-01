package com.learn.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author：江文谱
 * @date： 2020/5/1 22:12
 * @version： 1.0
 */
public class AdminUserDetails implements UserDetails {

    private UmsAdmin admin;
    private List<UmsPermission> umsPermissions;

    public AdminUserDetails(UmsAdmin admin, List<UmsPermission> umsPermissions) {
        this.admin = admin;
        this.umsPermissions = umsPermissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        //返回当前用户权限
        return umsPermissions.stream()
                .filter(permission -> permission.getValue() != null)
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
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
        return admin.getStatus().equals(1);
    }
}
