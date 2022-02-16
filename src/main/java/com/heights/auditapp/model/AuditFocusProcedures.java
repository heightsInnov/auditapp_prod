package com.heights.auditapp.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AUDIT_FOCUS_PROCEDURES")
public class AuditFocusProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FOCUS_ID")
    private Long focusId;

    @Column(name = "PROCEDURE")
    private String procedure;

    @Column(name = "DATE_CREATED")
    private LocalDate dateCreated;

    @Column(name = "AUTH_STAT")
    private String authStat;

    @Column(name = "DUE_DATE")
    private LocalDate dueDate;

    @Column(name = "EXCEPTION_FLAG")
    private String exceptionFlag;

    @Column(name = "EXCEPTION")
    private String exception;

    @Column(name = "RECOMMENDATION")
    private String recommendation;

    @Column(name = "RECIPIENT_EMAIL")
    private String recipientEmail;

    @Column(name = "RECIPIENT_NAME")
    private String recipientName;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;

    @Column(name = "RISK_RATING")
    private String riskRating;

    @Column(name = "SCHEDULED_FLAG")
    private String scheduledFlag;

    @Column(name = "SCHEDULLED_DATE")
    private LocalDate schedulledDate;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "START_FLAG")
    private String startFlag;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "WORK_PROGRAM_START")
    private String workProgramStart;

    @Column(name = "PROGRESS_LEVEL")
    private Long progressLevel;

    @Column(name = "CONTROL_STATUS")
    private String controlStatus;

    @Column(name = "COMMENTS")
    private String comments;

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
