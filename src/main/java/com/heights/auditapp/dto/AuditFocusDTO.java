package com.heights.auditapp.dto;

import com.heights.auditapp.model.AuditScopeEntity;

import java.sql.Date;

public class AuditFocusDTO extends AbstractDTO<Long> {
    private Long id;
    private Long scopeId;
    private String areaOfFocus;
    private String viewFlag = "N";
    private String scheduledFlag = "N";
    private Date schedulledDate;
    private Date startDate;
    private String workProgramStart;
    private String startFlag = "N";
    private String riskRating;
    private String focusException;
    private String focusRecommendation;
    private String comments;
    private String controlStatus;
    private String requestAdditionalInfo;
    private String recipientName;
    private String recipientEmail;
    private Date dueDate;
    private String exceptionFlag = "N";
    private String approvalStatus = "D";
    private String userName;
    private String recordStat = "O";
    private String authStat = "A";
    private Date createDate;
    private AuditScopeEntity auditScopeByScopeId;

    public AuditFocusDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public String getAreaOfFocus() {
        return this.areaOfFocus;
    }

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    public String getViewFlag() {
        return this.viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag;
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

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getWorkProgramStart() {
        return this.workProgramStart;
    }

    public void setWorkProgramStart(String workProgramStart) {
        this.workProgramStart = workProgramStart;
    }

    public String getStartFlag() {
        return this.startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getRiskRating() {
        return this.riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
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

    public String getRequestAdditionalInfo() {
        return this.requestAdditionalInfo;
    }

    public void setRequestAdditionalInfo(String requestAdditionalInfo) {
        this.requestAdditionalInfo = requestAdditionalInfo;
    }

    public String getRecipientName() {
        return this.recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientEmail() {
        return this.recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
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

    public AuditScopeEntity getAuditScopeByScopeId() {
        return this.auditScopeByScopeId;
    }

    public void setAuditScopeByScopeId(AuditScopeEntity auditScopeByScopeId) {
        this.auditScopeByScopeId = auditScopeByScopeId;
    }
}