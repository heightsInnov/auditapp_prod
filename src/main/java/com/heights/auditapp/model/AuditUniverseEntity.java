package com.heights.auditapp.model;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "AUDIT_UNIVERSE", schema = "AUDITAPP")
public class AuditUniverseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    private BigInteger id;
    @Basic
    @Column(name = "UNIVERSE_NAME", nullable = false, length = 2000)
    private String universeName;
    @Basic
    @Column(name = "RECORD_STAT", nullable = true, length = 1)
    private String recordStat;
    @Basic
    @Column(name = "AUTH_STAT", nullable = true, length = 1)
    private String authStat;
    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUniverseName() {
        return universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }

    public String getRecordStat() {
        return recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public String getAuthStat() {
        return authStat;
    }

    public void setAuthStat(String authStat) {
        this.authStat = authStat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuditUniverseEntity that = (AuditUniverseEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (universeName != null ? !universeName.equals(that.universeName) : that.universeName != null) return false;
        if (recordStat != null ? !recordStat.equals(that.recordStat) : that.recordStat != null) return false;
        if (authStat != null ? !authStat.equals(that.authStat) : that.authStat != null) return false;
        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (universeName != null ? universeName.hashCode() : 0);
        result = 31 * result + (recordStat != null ? recordStat.hashCode() : 0);
        result = 31 * result + (authStat != null ? authStat.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
