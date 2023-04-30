package com.example.datastorageproject.Model;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permission.ADMIN_PERMISSION_WRITE, Permission.ADMIN_PERMISSION_READ)),
    CUSTOMER(Set.of(Permission.CUSTOMER_PERMISSION_WRITE, Permission.CUSTOMER_PERMISSION_READ)),
    EMPLOYEE(Set.of(Permission.EMPLOYEE_PERMISSION_WRITE, Permission.EMPLOYEE_PERMISSION_READ));
    private final Set<Permission> permission;

    Role(Set<Permission> permission){
        this.permission = permission;
    }
    public Set<Permission> getPermissions(){
        return permission;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
