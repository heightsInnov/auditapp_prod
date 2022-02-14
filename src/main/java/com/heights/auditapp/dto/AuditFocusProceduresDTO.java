package com.heights.auditapp.dto;

import java.time.LocalDate;

public class AuditFocusProceduresDTO extends AbstractDTO<Long> {
    private Long focusId;
    private String procedure;
    private LocalDate dateCreated;
    private String authStat;
    private LocalDate dueDate;
    private String exceptionFlag;
    private String exception;
    private String recommendation;
    private String recipientEmail;
    private String recipientName;
    private String recordStat;
    private String additionalInfo;
    private String riskRating;
    private String scheduledFlag;
    private LocalDate schedulledDate;
    private LocalDate startDate;
    private String startFlag;
    private String userId;
    private String workProgramStart;
    private Long progressLevel;
    private String controlStatus;
    private String comments;

    public AuditFocusProceduresDTO() {
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

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
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

    public LocalDate getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(LocalDate schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
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