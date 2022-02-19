package com.heights.auditapp.dto;

import com.heights.auditapp.model.Approval_Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class AuditScopeDTO extends AbstractDTO<Long> {
    private Long scopeId; 
    private String scopeDef; 
    private Approval_Status approvalStatus = Approval_Status.DRAFT;
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate auditEndDate;
    private String auditPeriod;
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate auditStartDate;
    private String auditType; 
    private String authStat = "A";
    private LocalDate createDate = LocalDate.now();
    private Long entityId; 
    private String frequency;
    private String recordStat = "O";
    private String riskRating;
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate schedulledDate;
    private String scopeObjectives;
    private String scopeOfAudit;
    private String scopePurpose;
    private String userName;
    private Long auditScopesById;
    private Long assignedTo;

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public AuditScopeDTO() {
    }

    public LocalDate getAuditEndDate() {
        return auditEndDate;
    }

    public void setAuditEndDate(LocalDate auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public LocalDate getAuditStartDate() {
        return auditStartDate;
    }

    public void setAuditStartDate(LocalDate auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public LocalDate getSchedulledDate() {
        return schedulledDate;
    }

    public void setSchedulledDate(LocalDate schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Approval_Status getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(Approval_Status approvalStatus) {
        this.approvalStatus = approvalStatus;
    }


    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public String getAuditPeriod() {
        return this.auditPeriod;
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