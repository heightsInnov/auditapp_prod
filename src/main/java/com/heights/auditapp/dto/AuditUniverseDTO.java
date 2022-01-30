package com.heights.auditapp.dto;

import java.util.Date;

public class AuditUniverseDTO extends AbstractDTO<Long> {
    private Long universeId;
    private String authStat = "A";
    private Date createDate = new Date();
    private String recordStat = "O";
    private String universeName;

    public AuditUniverseDTO() {
    }

    public Long getUniverseId() {
        return this.universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
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

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getUniverseName() {
        return this.universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }
}