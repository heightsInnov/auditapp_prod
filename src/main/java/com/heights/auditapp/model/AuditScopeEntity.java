package com.heights.auditapp.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "AUDIT_SCOPE", schema = "AUDITAPP")
public class AuditScopeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "ENTITY_ID", nullable = true, precision = 0)
    private BigInteger entityId;
    @Basic
    @Column(name = "SCOPE_OF_AUDIT", nullable = false, length = 3000)
    private String scopeOfAudit;
    @Basic
    @Column(name = "AUDIT_PERIOD", nullable = true, length = 3000)
    private String auditPeriod;
    @Basic
    @Column(name = "SCOPE_PURPOSE", nullable = true, length = 3000)
    private String scopePurpose;
    @Basic
    @Column(name = "SCOPE", nullable = true, length = 3000)
    private String scope;
    @Basic
    @Column(name = "SCOPE_OBJECTIVES", nullable = true, length = 3000)
    private String scopeObjectives;
    @Basic
    @Column(name = "RISK_RATING", nullable = true, length = 3000)
    private String riskRating;
    @Basic
    @Column(name = "FREQUENCY", nullable = true, length = 3000)
    private String frequency;
    @Basic
    @Column(name = "AUDIT_TYPE", nullable = true, length = 3000)
    private String auditType;
    @Basic
    @Column(name = "SCHEDULLED_DATE", nullable = true)
    private Date schedulledDate;
    @Basic
    @Column(name = "AUDIT_START_DATE", nullable = true)
    private Date auditStartDate;
    @Basic
    @Column(name = "AUDIT_END_DATE", nullable = true)
    private Date auditEndDate;
    @Basic
    @Column(name = "APPROVAL_STATUS", nullable = true, length = 3000)
    private String approvalStatus;
    @Basic
    @Column(name = "USER_NAME", nullable = true, length = 3000)
    private String userName;
    @Basic
    @Column(name = "RECORD_STAT", nullable = true, length = 1)
    private String recordStat;
    @Basic
    @Column(name = "AUTH_STAT", nullable = true, length = 1)
    private String authStat;
    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "auditScopesById")
    private AuditEntityEntity auditEntityByEntityId;

    public AuditEntityEntity getAuditEntityByEntityId() {
        return auditEntityByEntityId;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getEntityId() {
        return entityId;
    }

    public void setEntityId(BigInteger entityId) {
        this.entityId = entityId;
    }

    public String getScopeOfAudit() {
        return scopeOfAudit;
    }

    public void setScopeOfAudit(String scopeOfAudit) {
        this.scopeOfAudit = scopeOfAudit;
    }

    public String getAuditPeriod() {
        return auditPeriod;
    }

    public void setAuditPeriod(String auditPeriod) {
        this.auditPeriod = auditPeriod;
    }

    public String getScopePurpose() {
        return scopePurpose;
    }

    public void setScopePurpose(String scopePurpose) {
        this.scopePurpose = scopePurpose;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getScopeObjectives() {
        return scopeObjectives;
    }

    public void setScopeObjectives(String scopeObjectives) {
        this.scopeObjectives = scopeObjectives;
    }

    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Date getSchedulledDate() {
        return schedulledDate;
    }

    public void setSchedulledDate(Date schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public Date getAuditStartDate() {
        return auditStartDate;
    }

    public void setAuditStartDate(Date auditStartDate) {
        this.auditStartDate = auditStartDate;
    }

    public Date getAuditEndDate() {
        return auditEndDate;
    }

    public void setAuditEndDate(Date auditEndDate) {
        this.auditEndDate = auditEndDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRecordStat() {
        return recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getAuthStat() {
        return authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditScopeEntity that = (AuditScopeEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (entityId != null ? !entityId.equals(that.entityId) : that.entityId != null) return false;
        if (scopeOfAudit != null ? !scopeOfAudit.equals(that.scopeOfAudit) : that.scopeOfAudit != null) return false;
        if (auditPeriod != null ? !auditPeriod.equals(that.auditPeriod) : that.auditPeriod != null) return false;
        if (scopePurpose != null ? !scopePurpose.equals(that.scopePurpose) : that.scopePurpose != null) return false;
        if (scope != null ? !scope.equals(that.scope) : that.scope != null) return false;
        if (scopeObjectives != null ? !scopeObjectives.equals(that.scopeObjectives) : that.scopeObjectives != null)
            return false;
        if (riskRating != null ? !riskRating.equals(that.riskRating) : that.riskRating != null) return false;
        if (frequency != null ? !frequency.equals(that.frequency) : that.frequency != null) return false;
        if (auditType != null ? !auditType.equals(that.auditType) : that.auditType != null) return false;
        if (schedulledDate != null ? !schedulledDate.equals(that.schedulledDate) : that.schedulledDate != null)
            return false;
        if (auditStartDate != null ? !auditStartDate.equals(that.auditStartDate) : that.auditStartDate != null)
            return false;
        if (auditEndDate != null ? !auditEndDate.equals(that.auditEndDate) : that.auditEndDate != null) return false;
        if (approvalStatus != null ? !approvalStatus.equals(that.approvalStatus) : that.approvalStatus != null)
            return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (recordStat != null ? !recordStat.equals(that.recordStat) : that.recordStat != null) return false;
        if (authStat != null ? !authStat.equals(that.authStat) : that.authStat != null) return false;
        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (entityId != null ? entityId.hashCode() : 0);
        result = 31 * result + (scopeOfAudit != null ? scopeOfAudit.hashCode() : 0);
        result = 31 * result + (auditPeriod != null ? auditPeriod.hashCode() : 0);
        result = 31 * result + (scopePurpose != null ? scopePurpose.hashCode() : 0);
        result = 31 * result + (scope != null ? scope.hashCode() : 0);
        result = 31 * result + (scopeObjectives != null ? scopeObjectives.hashCode() : 0);
        result = 31 * result + (riskRating != null ? riskRating.hashCode() : 0);
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (auditType != null ? auditType.hashCode() : 0);
        result = 31 * result + (schedulledDate != null ? schedulledDate.hashCode() : 0);
        result = 31 * result + (auditStartDate != null ? auditStartDate.hashCode() : 0);
        result = 31 * result + (auditEndDate != null ? auditEndDate.hashCode() : 0);
        result = 31 * result + (approvalStatus != null ? approvalStatus.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (recordStat != null ? recordStat.hashCode() : 0);
        result = 31 * result + (authStat != null ? authStat.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
