package com.heights.auditapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUDIT_ENTITY")
public class AuditEntity {
    @Id
    @Column(name = "ENTITY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @Column(name = "AUTH_STAT")
    private String authStat;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "RECORD_STAT")
    private String recordStat;

    @Column(name = "UNIVERSE_ID")
    private Long universeId;

    public Long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
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

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getRecordStat() {
        return this.recordStat;
    }

    public void setRecordStat(String recordStat) {
        this.recordStat = recordStat;
    }

    public Long getUniverseId() {
        return this.universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
    }
}
