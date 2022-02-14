package com.heights.auditapp.model;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "CONTROL_STATUS")
    private String controlStatus;

    @Column(name = "CREATE_DATE")
    private LocalDate createDate;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "SCHEDULED_FLAG")
    private String scheduledFlag;

    @Column(name = "SCHEDULLED_DATE")
    private LocalDate schedulledDate;

    @Column(name = "SCOPE_ID")
    private Long scopeId;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "START_FLAG")
    private String startFlag;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PROGRESS_LEVEL")
    private Long progressLevel;

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

    public String getControlStatus() {
        return this.controlStatus;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
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

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
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

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProgressLevel() {
        return this.progressLevel;
    }

    public void setProgressLevel(Long progressLevel) {
        this.progressLevel = progressLevel;
    }
}
