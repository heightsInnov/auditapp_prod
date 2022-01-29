package com.heights.auditapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.heights.auditapp.model.AuditScopeEntity;
import com.heights.auditapp.model.AuditUniverseEntity;

import java.sql.Date;
import java.util.Collection;

public class AuditEntityDTO extends AbstractDTO<Long> {
    private Long id;
    private Long universeId;
    private String entityName;
    private String recordStat = "O";
    private String authStat = "A";
    private Date createDate;
    @JsonProperty("auditUniverse")
    private AuditUniverseEntity auditUniverseByUniverseId;
    private Collection<AuditScopeEntity> auditScopesById;

    public AuditEntityDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUniverseId() {
        return this.universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AuditUniverseEntity getAuditUniverseByUniverseId() {
        return this.auditUniverseByUniverseId;
    }

    public void setAuditUniverseByUniverseId(AuditUniverseEntity auditUniverseByUniverseId) {
        this.auditUniverseByUniverseId = auditUniverseByUniverseId;
    }

    public Collection<AuditScopeEntity> getAuditScopesById() {
        return this.auditScopesById;
    }

    public void setAuditScopesById(Collection<AuditScopeEntity> auditScopesById) {
        this.auditScopesById = auditScopesById;
    }
}