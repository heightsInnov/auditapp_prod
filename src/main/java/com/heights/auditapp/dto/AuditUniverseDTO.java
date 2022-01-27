package com.heights.auditapp.dto;

import java.math.BigInteger;
import java.sql.Date;

public class AuditUniverseDTO extends AbstractDTO<BigInteger> {
    private BigInteger id;
    private String universeName;
    private String recordStat;
    private String authStat;
    private Date createDate;

    public AuditUniverseDTO() {
    }

    public java.math.BigInteger getId() {
        return this.id;
    }

    public void setId(java.math.BigInteger id) {
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

    public java.sql.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.sql.Date createDate) {
        this.createDate = createDate;
    }
}