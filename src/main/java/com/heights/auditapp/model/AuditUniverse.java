package com.heights.auditapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUDIT_UNIVERSE")
public class AuditUniverse {
    @Id
    @Column(name = "UNIVERSE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long universeId;

    @Column(name = "AUTH_STAT")
    private String authStat;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "UNIVERSE_NAME", unique = true)
    private String universeName;

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
