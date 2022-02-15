package com.heights.auditapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AUDIT_SCOPE")
public class AuditScope {
    @Id
    @Column(name = "SCOPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scopeId;

    @Column(name = "APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name = "AUDIT_END_DATE")
    private LocalDate auditEndDate;

    @Column(name = "AUDIT_PERIOD")
    private String auditPeriod;

    @Column(name = "AUDIT_START_DATE")
    private LocalDate auditStartDate;

    @Column(name = "AUDIT_TYPE")
    private String auditType;

    @Column(name = "AUTH_STAT")
    private String authStat;

    @Column(name = "CREATE_DATE")
    private LocalDate createDate;

    @Column(name = "ENTITY_ID")
    private Long entityId;

    @Column(name = "FREQUENCY")
    private String frequency;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "RISK_RATING")
    private String riskRating;

    @Column(name = "SCHEDULLED_DATE")
    private LocalDate schedulledDate;

    @Column(name = "SCOPE_DEF")
    private String scopeDef;

    @Column(name = "SCOPE_OBJECTIVES")
    private String scopeObjectives;

    @Column(name = "SCOPE_OF_AUDIT")
    private String scopeOfAudit;

    @Column(name = "SCOPE_PURPOSE")
    private String scopePurpose;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "AUDIT_SCOPES_BY_ID")
    private Long auditScopesById;

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

    public LocalDate getAuditEndDate() {
        return this.auditEndDate;
    }

    public void setAuditEndDate(LocalDate auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public String getAuditPeriod() {
        return this.auditPeriod;
    }

    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public LocalDate getAuditStartDate() {
        return this.auditStartDate;
    }

    public void setAuditStartDate(LocalDate auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public String getAuditType() {
        return this.auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
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

    public LocalDate getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(LocalDate schedulledDate) {
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
