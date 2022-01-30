package com.heights.auditapp.dto;

import java.util.Date;

public class AuditDTO extends AbstractDTO<Long> {
    private Long entityId;
    private String authStat = "A";
    private Date createDate = new Date();
    private String entityName;
    private String recordStat = "O";
    private Long universeId;

    public AuditDTO() {
    }

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