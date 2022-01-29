package com.heights.auditapp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "AUDIT_ENTITY", schema = "AUDITAPP")
@IdClass(AuditEntityId.class)
public class AuditEntityEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    @Id
    @Basic
    @Column(name = "UNIVERSE_ID", nullable = false)
    private Long universeId;
    @Id
    @Basic
    @Column(name = "ENTITY_NAME", nullable = false, length = 2000)
    private String entityName;
    @Basic
    @Column(name = "RECORD_STAT", nullable = true, length = 1, columnDefinition = "varchar(1) default 'O'")
    private String recordStat;
    @Basic
    @Column(name = "AUTH_STAT", nullable = true, length = 1, columnDefinition = "varchar(1) default 'A'")
    private String authStat;
    @Basic
    @Column(name = "CREATE_DATE", nullable = true)
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private AuditUniverseEntity auditUniverseByUniverseId;
    @JsonManagedReference
    @OneToMany(mappedBy = "auditEntityByEntityId", cascade = CascadeType.ALL)
    private Collection<AuditScopeEntity> auditScopesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUniverseId() {
        return universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
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

        AuditEntityEntity that = (AuditEntityEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (universeId != null ? !universeId.equals(that.universeId) : that.universeId != null) return false;
        if (entityName != null ? !entityName.equals(that.entityName) : that.entityName != null) return false;
        if (recordStat != null ? !recordStat.equals(that.recordStat) : that.recordStat != null) return false;
        if (authStat != null ? !authStat.equals(that.authStat) : that.authStat != null) return false;
        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (universeId != null ? universeId.hashCode() : 0);
        result = 31 * result + (entityName != null ? entityName.hashCode() : 0);
        result = 31 * result + (recordStat != null ? recordStat.hashCode() : 0);
        result = 31 * result + (authStat != null ? authStat.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }

    public AuditUniverseEntity getAuditUniverseByUniverseId() {
        return auditUniverseByUniverseId;
    }

    public void setAuditUniverseByUniverseId(AuditUniverseEntity auditUniverseByUniverseId) {
        this.auditUniverseByUniverseId = auditUniverseByUniverseId;
    }

    public Collection<AuditScopeEntity> getAuditScopesById() {
        return auditScopesById;
    }

    public void setAuditScopesById(Collection<AuditScopeEntity> auditScopesById) {
        this.auditScopesById = auditScopesById;
    }
}
