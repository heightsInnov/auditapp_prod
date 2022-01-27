package com.heights.auditapp.dto;

import com.heights.auditapp.model.AuditScopeEntity;
import com.heights.auditapp.model.AuditUniverseEntity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;

public class AuditEntityDTO extends AbstractDTO<BigInteger> {
    private BigInteger id;
    private BigInteger universeId;
    private String entityName;
    private String recordStat;
    private String authStat;
    private Date createDate;
    private AuditUniverseEntity auditUniverseByUniverseId;
    private Collection<AuditScopeEntity> auditScopesById;

    public AuditEntityDTO() {
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUniverseId() {
        return this.universeId;
    }

    public void setUniverseId(BigInteger universeId) {
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