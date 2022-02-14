package com.heights.auditapp.dto;

public class AuditFocusProceduresDTO extends AbstractDTO<Long> {
    private Long id;
    private Long focusId;
    private String procedure;
    private Date dateCreated;
    private String authStat;
    private Date dueDate;
    private String exceptionFlag;
    private String exception;
    private String recommendation;
    private String recipientEmail;
    private String recipientName;
    private String recordStat;
    private String additionalInfo;
    private String riskRating;
    private String scheduledFlag;
    private Date schedulledDate;
    private Date startDate;
    private String startFlag;
    private String userId;
    private String workProgramStart;
    private Long progressLevel;
    private String controlStatus;
    private String comments;

    public AuditFocusProceduresDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFocusId() {
        return this.focusId;
    }

    public void setFocusId(Long focusId) {
        this.focusId = focusId;
    }

    public String getProcedure() {
        return this.procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public java.sql.Date getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(java.sql.Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public java.sql.Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(java.sql.Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getExceptionFlag() {
        return this.exceptionFlag;
    }

    public void setExceptionFlag(String exceptionFlag) {
        this.exceptionFlag = exceptionFlag;
    }

    public String getException() {
        return this.exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getRecommendation() {
        return this.recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
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

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
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

    public java.sql.Date getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(java.sql.Date schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public java.sql.Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(java.sql.Date startDate) {
        this.startDate = startDate;
    }

    public String getStartFlag() {
        return this.startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkProgramStart() {
        return this.workProgramStart;
    }

    public void setWorkProgramStart(String workProgramStart) {
        this.workProgramStart = workProgramStart;
    }

    public Long getProgressLevel() {
        return this.progressLevel;
    }

    public void setProgressLevel(Long progressLevel) {
        this.progressLevel = progressLevel;
    }

    public String getControlStatus() {
        return this.controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}