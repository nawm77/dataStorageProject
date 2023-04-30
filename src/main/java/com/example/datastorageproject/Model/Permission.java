package com.example.datastorageproject.Model;

import lombok.Getter;

public enum Permission {
    CUSTOMER_PERMISSION_WRITE("customer:write"),
    CUSTOMER_PERMISSION_READ("customer:read"),
    ADMIN_PERMISSION_WRITE("admin:write"),
    ADMIN_PERMISSION_READ("admin:read"),
    EMPLOYEE_PERMISSION_WRITE("employee:write"),
    EMPLOYEE_PERMISSION_READ("employee:read");
    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
