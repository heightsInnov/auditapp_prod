package com.heights.auditapp.dto;

import java.util.Date;

public class AuditScopeDTO extends AbstractDTO<Long> {
    private Long scopeId; //
    private String scopeDef; //
    private String approvalStatus = "D"; //auto
    private String auditEndDate;//
    private String auditPeriod; //
    private String auditStartDate; //
    private String auditType; //
    private String authStat = "A";
    private Date createDate = new Date();
    private Long entityId; //
    private String frequency;
    private String recordStat = "O";
    private String riskRating;
    private String schedulledDate;
    private String scopeObjectives;
    private String scopeOfAudit;
    private String scopePurpose;
    private String userName;
    private Long auditScopesById;

    public AuditScopeDTO() {
    }

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAuditEndDate() {
        return this.auditEndDate;
    }

    public void setAuditEndDate(String auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public String getAuditPeriod() {
        return this.auditPeriod;
    }

    public String getAuditStartDate() {
        return this.auditStartDate;
    }

    public void setAuditStartDate(String auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public String getAuditType() {
        return this.auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getRiskRating() {
        return this.riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(String schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public String getScopeDef() {
        return this.scopeDef;
    }

    public void setScopeDef(String scopeDef) {
        this.scopeDef = scopeDef;
    }

    public String getScopeObjectives() {
        return this.scopeObjectives;
    }

    public void setScopeObjectives(String scopeObjectives) {
        this.scopeObjectives = scopeObjectives;
    }

    public String getScopeOfAudit() {
        return this.scopeOfAudit;
    }

    public void setScopeOfAudit(String scopeOfAudit) {
        this.scopeOfAudit = scopeOfAudit;
    }

    public String getScopePurpose() {
        return this.scopePurpose;
    }

    public void setScopePurpose(String scopePurpose) {
        this.scopePurpose = scopePurpose;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getAuditScopesById() {
        return this.auditScopesById;
    }

    public void setAuditScopesById(Long auditScopesById) {
        this.auditScopesById = auditScopesById;
    }
}