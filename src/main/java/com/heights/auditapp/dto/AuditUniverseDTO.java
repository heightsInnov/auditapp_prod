package com.heights.auditapp.dto;

import java.sql.Date;

public class AuditUniverseDTO extends AbstractDTO<Long> {
    private Long id;
    private String universeName;
    private String recordStat = "O";
    private String authStat = "A";
    private Date createDate;

    public AuditUniverseDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniverseName() {
        return this.universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
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
}