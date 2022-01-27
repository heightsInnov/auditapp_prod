package com.heights.auditapp.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "AUDIT_FOCUS", schema = "AUDITAPP")
public class AuditFocusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "SCOPE_ID", nullable = true, precision = 0, insertable = false, updatable = false)
    private BigInteger scopeId;
    @Basic
    @Column(name = "AREA_OF_FOCUS", nullable = false, length = 3000)
    private String areaOfFocus;
    @Basic
    @Column(name = "VIEW_FLAG", nullable = true, length = 1)
    private String viewFlag;
    @Basic
    @Column(name = "SCHEDULED_FLAG", nullable = true, length = 1)
    private String scheduledFlag;
    @Basic
    @Column(name = "SCHEDULLED_DATE", nullable = true)
    private Date schedulledDate;
    @Basic
    @Column(name = "START_DATE", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "WORK_PROGRAM_START", nullable = true, length = 3000)
    private String workProgramStart;
    @Basic
    @Column(name = "START_FLAG", nullable = true, length = 1)
    private String startFlag;
    @Basic
    @Column(name = "RISK_RATING", nullable = true, length = 3000)
    private String riskRating;
    @Basic
    @Column(name = "FOCUS_EXCEPTION", nullable = true, length = 3000)
    private String focusException;
    @Basic
    @Column(name = "FOCUS_RECOMMENDATION", nullable = true, length = 3000)
    private String focusRecommendation;
    @Basic
    @Column(name = "COMMENTS", nullable = true, length = 3000)
    private String comments;
    @Basic
    @Column(name = "CONTROL_STATUS", nullable = true, length = 3000)
    private String controlStatus;
    @Basic
    @Column(name = "REQUEST_ADDITIONAL_INFO", nullable = true, length = 3000)
    private String requestAdditionalInfo;
    @Basic
    @Column(name = "RECIPIENT_NAME", nullable = true, length = 3000)
    private String recipientName;
    @Basic
    @Column(name = "RECIPIENT_EMAIL", nullable = true, length = 3000)
    private String recipientEmail;
    @Basic
    @Column(name = "DUE_DATE", nullable = true)
    private Date dueDate;
    @Basic
    @Column(name = "EXCEPTION_FLAG", nullable = true, length = 1)
    private String exceptionFlag;
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
    @JoinColumn(name = "SCOPE_ID", referencedColumnName = "ID")
    private AuditScopeEntity auditScopeByScopeId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getScopeId() {
        return scopeId;
    }

    public void setScopeId(BigInteger scopeId) {
        this.scopeId = scopeId;
    }

    public String getAreaOfFocus() {
        return areaOfFocus;
    }

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    public String getViewFlag() {
        return viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag;
    }

    public String getScheduledFlag() {
        return scheduledFlag;
    }

    public void setScheduledFlag(String scheduledFlag) {
        this.scheduledFlag = scheduledFlag;
    }

    public Date getSchedulledDate() {
        return schedulledDate;
    }

    public void setSchedulledDate(Date schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWorkProgramStart() {
        return workProgramStart;
    }

    public void setWorkProgramStart(String workProgramStart) {
        this.workProgramStart = workProgramStart;
    }

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getFocusException() {
        return focusException;
    }

    public void setFocusException(String focusException) {
        this.focusException = focusException;
    }

    public String getFocusRecommendation() {
        return focusRecommendation;
    }

    public void setFocusRecommendation(String focusRecommendation) {
        this.focusRecommendation = focusRecommendation;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getControlStatus() {
        return controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getRequestAdditionalInfo() {
        return requestAdditionalInfo;
    }

    public void setRequestAdditionalInfo(String requestAdditionalInfo) {
        this.requestAdditionalInfo = requestAdditionalInfo;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getExceptionFlag() {
        return exceptionFlag;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
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

        AuditFocusEntity that = (AuditFocusEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (scopeId != null ? !scopeId.equals(that.scopeId) : that.scopeId != null) return false;
        if (areaOfFocus != null ? !areaOfFocus.equals(that.areaOfFocus) : that.areaOfFocus != null) return false;
        if (viewFlag != null ? !viewFlag.equals(that.viewFlag) : that.viewFlag != null) return false;
        if (scheduledFlag != null ? !scheduledFlag.equals(that.scheduledFlag) : that.scheduledFlag != null)
            return false;
        if (schedulledDate != null ? !schedulledDate.equals(that.schedulledDate) : that.schedulledDate != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (workProgramStart != null ? !workProgramStart.equals(that.workProgramStart) : that.workProgramStart != null)
            return false;
        if (startFlag != null ? !startFlag.equals(that.startFlag) : that.startFlag != null) return false;
        if (riskRating != null ? !riskRating.equals(that.riskRating) : that.riskRating != null) return false;
        if (focusException != null ? !focusException.equals(that.focusException) : that.focusException != null)
            return false;
        if (focusRecommendation != null ? !focusRecommendation.equals(that.focusRecommendation) : that.focusRecommendation != null)
            return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (controlStatus != null ? !controlStatus.equals(that.controlStatus) : that.controlStatus != null)
            return false;
        if (requestAdditionalInfo != null ? !requestAdditionalInfo.equals(that.requestAdditionalInfo) : that.requestAdditionalInfo != null)
            return false;
        if (recipientName != null ? !recipientName.equals(that.recipientName) : that.recipientName != null)
            return false;
        if (recipientEmail != null ? !recipientEmail.equals(that.recipientEmail) : that.recipientEmail != null)
            return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (exceptionFlag != null ? !exceptionFlag.equals(that.exceptionFlag) : that.exceptionFlag != null)
            return false;
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
        result = 31 * result + (scopeId != null ? scopeId.hashCode() : 0);
        result = 31 * result + (areaOfFocus != null ? areaOfFocus.hashCode() : 0);
        result = 31 * result + (viewFlag != null ? viewFlag.hashCode() : 0);
        result = 31 * result + (scheduledFlag != null ? scheduledFlag.hashCode() : 0);
        result = 31 * result + (schedulledDate != null ? schedulledDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (workProgramStart != null ? workProgramStart.hashCode() : 0);
        result = 31 * result + (startFlag != null ? startFlag.hashCode() : 0);
        result = 31 * result + (riskRating != null ? riskRating.hashCode() : 0);
        result = 31 * result + (focusException != null ? focusException.hashCode() : 0);
        result = 31 * result + (focusRecommendation != null ? focusRecommendation.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (controlStatus != null ? controlStatus.hashCode() : 0);
        result = 31 * result + (requestAdditionalInfo != null ? requestAdditionalInfo.hashCode() : 0);
        result = 31 * result + (recipientName != null ? recipientName.hashCode() : 0);
        result = 31 * result + (recipientEmail != null ? recipientEmail.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (exceptionFlag != null ? exceptionFlag.hashCode() : 0);
        result = 31 * result + (approvalStatus != null ? approvalStatus.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (recordStat != null ? recordStat.hashCode() : 0);
        result = 31 * result + (authStat != null ? authStat.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    public AuditScopeEntity getAuditScopeByScopeId() {
        return auditScopeByScopeId;
    }

    public void setAuditScopeByScopeId(AuditScopeEntity auditScopeByScopeId) {
        this.auditScopeByScopeId = auditScopeByScopeId;
    }
}
