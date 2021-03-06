package com.heights.auditapp.dto;

import java.util.Date;

public class AuditUserDTO extends AbstractDTO<Long> {
    private Long userId;
    private String username;
    private String password;
    private Long role;
    private Long supvrole;
    private String supvroleName;
    private Date createdDate;
    private String roleName;
    private String isActive;

    public String getSupvroleName() {
        return supvroleName;
    }

    public void setSupvroleName(String supvroleName) {
        this.supvroleName = supvroleName;
    }

    public Long getSupvrole() {
        return supvrole;
    }

    public void setSupvrole(Long supvrole) {
        this.supvrole = supvrole;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AuditUserDTO() {
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole() {
        return this.role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    public java.util.Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(java.util.Date createdDate) {
        this.createdDate = createdDate;
    }
}