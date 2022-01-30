package com.heights.auditapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AUDIT_ROLE")
public class AuditRole {
    @Id
    @Column(name = "ROLE_ID")
    private Long roleId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE_CREATED")
    private Date dateCreated;

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
