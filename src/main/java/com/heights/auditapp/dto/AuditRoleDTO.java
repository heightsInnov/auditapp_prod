package com.heights.auditapp.dto;

import java.util.Date;

public class AuditRoleDTO extends AbstractDTO<Long> {
    private Long roleId;
    private String name;
    private Date dateCreated;

    public AuditRoleDTO() {
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}