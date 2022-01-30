package com.heights.auditapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUDIT_FOCUS")
public class AuditFocus {
    @Id
    @Column(name = "FOCUS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long focusId;

    @Column(name = "APPROVAL_STATUS")
    private String approvalStatus;

    @Column(name = "AREA_OF_FOCUS")
    private String areaOfFocus;

    @Column(name = "AUTH_STAT")
    private String authStat;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "CONTROL_STATUS")
    private String controlStatus;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "EXCEPTION_FLAG")
    private String exceptionFlag;

    @Column(name = "FOCUS_EXCEPTION")
    private String focusException;

    @Column(name = "FOCUS_RECOMMENDATION")
    private String focusRecommendation;

    @Column(name = "RECIPIENT_EMAIL")
    private String recipientEmail;

    @Column(name = "RECIPIENT_NAME")
    private String recipientName;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "REQUEST_ADDITIONAL_INFO")
    private String requestAdditionalInfo;

    @Column(name = "RISK_RATING")
    private String riskRating;

    @Column(name = "SCHEDULED_FLAG")
    private String scheduledFlag;

    @Column(name = "SCHEDULLED_DATE")
    private Date schedulledDate;

    @Column(name = "SCOPE_ID")
    private Long scopeId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "START_FLAG")
    private String startFlag;

    @Column(name = "USER_ID")
    private Long userName;

    @Column(name = "VIEW_FLAG")
    private String viewFlag;

    @Column(name = "WORK_PROGRAM_START")
    private String workProgramStart;

    public Long getFocusId() {
        return this.focusId;
    }

    public void setFocusId(Long focusId) {
        this.focusId = focusId;
    }

    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAreaOfFocus() {
        return this.areaOfFocus;
    }

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getControlStatus() {
        return this.controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getExceptionFlag() {
        return this.exceptionFlag;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public String getFocusException() {
        return this.focusException;
    }

    public void setFocusException(String focusException) {
        this.focusException = focusException;
    }

    public String getFocusRecommendation() {
        return this.focusRecommendation;
    }

    public void setFocusRecommendation(String focusRecommendation) {
        this.focusRecommendation = focusRecommendation;
    }

    public String getRecipientEmail() {
        return this.recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getRequestAdditionalInfo() {
        return this.requestAdditionalInfo;
    }

    public void setRequestAdditionalInfo(String requestAdditionalInfo) {
        this.requestAdditionalInfo = requestAdditionalInfo;
    }

    public String getRiskRating() {
        return this.riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getScheduledFlag() {
        return this.scheduledFlag;
    }

    public void setScheduledFlag(String scheduledFlag) {
        this.scheduledFlag = scheduledFlag;
    }

    public Date getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(Date schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getStartFlag() {
        return this.startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public Long getUserName() {
        return this.userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }

    public String getViewFlag() {
        return this.viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag;
    }

    public String getWorkProgramStart() {
        return this.workProgramStart;
    }

    public void setWorkProgramStart(String workProgramStart) {
        this.workProgramStart = workProgramStart;
    }
}
