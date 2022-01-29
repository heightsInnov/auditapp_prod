package com.heights.auditapp.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "AUDIT_UNIVERSE", schema = "AUDITAPP")
public class AuditUniverseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false, unique = true, precision = 0)
    private Long universeId;
    @Basic
    @Column(name = "UNIVERSE_NAME", nullable = false, length = 2000, unique = true)
    private String universeName;
    @Basic
    @Column(name = "RECORD_STAT", nullable = true, length = 1, columnDefinition = "varchar(1) default 'O'")
    private String recordStat = "O";
    @Basic
    @Column(name = "AUTH_STAT", nullable = true, length = 1, columnDefinition = "varchar(1) default 'A'")
    private String authStat = "A";
    @Basic
    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate = new Date(new java.util.Date().getTime());

//    @JsonIgnore
//    @OneToMany(mappedBy = "universe")
//    private Set<AuditEntityEntity> auditEntityEntities;

//    public Set<AuditEntityEntity> getAuditEntityEntities() {
//        return auditEntityEntities;
//    }
//
//    public void setAuditEntityEntities(Set<AuditEntityEntity> auditEntityEntities) {
//        this.auditEntityEntities = auditEntityEntities;
//    }

    public Long getUniverseId() {
        return universeId;
    }

    public void setUniverseId(Long id) {
        this.universeId = id;
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

        if (universeId != null ? !universeId.equals(that.universeId) : that.universeId != null) return false;
        if (universeName != null ? !universeName.equals(that.universeName) : that.universeName != null) return false;
        if (recordStat != null ? !recordStat.equals(that.recordStat) : that.recordStat != null) return false;
        if (authStat != null ? !authStat.equals(that.authStat) : that.authStat != null) return false;
        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = universeId != null ? universeId.hashCode() : 0;
        result = 31 * result + (universeName != null ? universeName.hashCode() : 0);
        result = 31 * result + (recordStat != null ? recordStat.hashCode() : 0);
        result = 31 * result + (authStat != null ? authStat.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
