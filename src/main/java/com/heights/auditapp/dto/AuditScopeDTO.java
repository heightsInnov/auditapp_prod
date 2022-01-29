package com.heights.auditapp.dto;

import com.heights.auditapp.model.AuditEntityEntity;

import java.sql.Date;

public class AuditScopeDTO extends AbstractDTO<Long> {
    private Long id;
    private Long entityId;
    private String scopeOfAudit;
    private String auditPeriod;
    private String scopePurpose;
    private String scope;
    private String scopeObjectives;
    private String riskRating;
    private String frequency;
    private String auditType;
    private Date schedulledDate;
    private Date auditStartDate;
    private Date auditEndDate;
    private String approvalStatus;
    private String userName;
    private String recordStat = "O";
    private String authStat = "A";
    private Date createDate;
    private AuditEntityEntity auditEntityByEntityId;

    public AuditScopeDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getScopeOfAudit() {
        return this.scopeOfAudit;
    }

    public void setScopeOfAudit(String scopeOfAudit) {
        this.scopeOfAudit = scopeOfAudit;
    }

    public String getAuditPeriod() {
        return this.auditPeriod;
    }

    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public String getScopePurpose() {
        return this.scopePurpose;
    }

    public void setScopePurpose(String scopePurpose) {
        this.scopePurpose = scopePurpose;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScopeObjectives() {
        return this.scopeObjectives;
    }

    public void setScopeObjectives(String scopeObjectives) {
        this.scopeObjectives = scopeObjectives;
    }

    public String getRiskRating() {
        return this.riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAuditType() {
        return this.auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Date getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(Date schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public Date getAuditStartDate() {
        return this.auditStartDate;
    }

    public void setAuditStartDate(Date auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public Date getAuditEndDate() {
        return this.auditEndDate;
    }

    public void setAuditEndDate(Date auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public AuditEntityEntity getAuditEntityByEntityId() {
        return this.auditEntityByEntityId;
    }

    public void setAuditEntityByEntityId(AuditEntityEntity auditEntityByEntityId) {
        this.auditEntityByEntityId = auditEntityByEntityId;
    }
}