package com.heights.auditapp.dto;

import java.util.Date;

public class AuditFocusDTO extends AbstractDTO<Long> {
    private Long focusId;
    private String approvalStatus = "D";
    private String areaOfFocus; //
    private String authStat = "A";
    private String comments;
    private String controlStatus; //
    private Date createDate = new Date();
    private Date dueDate; //
    private String exceptionFlag = "N";
    private String focusException; //
    private String focusRecommendation; //
    private String recipientEmail; //
    private String recipientName; //
    private String recordStat = "O";
    private String requestAdditionalInfo;
    private String riskRating;  //
    private String scheduledFlag = "N";
    private Date schedulledDate;//
    private Long scopeId;
    private Date startDate; //
    private String startFlag = "N";
    private Long userName;
    private String viewFlag = "N";
    private String workProgramStart; //

    public AuditFocusDTO() {
    }

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

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    public String getAreaOfFocus() {
        return this.areaOfFocus;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return this.comments;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getControlStatus() {
        return this.controlStatus;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public String getExceptionFlag() {
        return this.exceptionFlag;
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

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getRecordStat() {
        return this.recordStat;
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