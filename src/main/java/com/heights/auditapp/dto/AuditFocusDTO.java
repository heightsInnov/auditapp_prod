package com.heights.auditapp.dto;

import com.heights.auditapp.model.Approval_Status;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

public class AuditFocusDTO extends AbstractDTO<Long> {
    private Long focusId;
    private Approval_Status approvalStatus = Approval_Status.SCHEDULED;
    private String areaOfFocus;
    private String authStat = "A";
    private String controlStatus ;
    private LocalDate createDate = LocalDate.now();
    private String recordStat = "O";
    private String scheduledFlag = "N";
    @Nullable
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate schedulledDate;
    private Long scopeId;
    @Nullable
    private LocalDate startDate;
    private String startFlag = "N";
    private Long userId;
    private int progressLevel = 0;
    private int procedureCount = 0;

    public int getProcedureCount() {
        return procedureCount;
    }

    public void setProcedureCount(int procedureCount) {
        this.procedureCount = procedureCount;
    }

    public AuditFocusDTO() {
    }

    public void setFocusId(Long focusId) {
        this.focusId = focusId;
    }

    public Long getFocusId() {
        return this.focusId;
    }

    public Approval_Status getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(Approval_Status approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public void setAreaOfFocus(String areaOfFocus) {
        this.areaOfFocus = areaOfFocus;
    }

    public String getAreaOfFocus() {
        return this.areaOfFocus;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public String getAuthStat() {
        return this.authStat;
    }

    public void setControlStatus(String controlStatus) {
        this.controlStatus = controlStatus;
    }

    public String getControlStatus() {
        return this.controlStatus;
    }

    public LocalDate getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setScheduledFlag(String scheduledFlag) {
        this.scheduledFlag = scheduledFlag;
    }

    public String getScheduledFlag() {
        return this.scheduledFlag;
    }

    public LocalDate getSchedulledDate() {
        return this.schedulledDate;
    }

    public void setSchedulledDate(LocalDate schedulledDate) {
        this.schedulledDate = schedulledDate;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Long getScopeId() {
        return this.scopeId;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getStartFlag() {
        return this.startFlag;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getProgressLevel() {
        return this.progressLevel;
    }

    public void setProgressLevel(int progressLevel) {
        this.progressLevel = progressLevel;
    }
}