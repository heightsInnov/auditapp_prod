package com.heights.auditapp.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuditEntityId implements Serializable {
    private Long id;
    private Long universeId;
    private String entityName;

    public AuditEntityId(Long id, Long universeId, String entityName) {
        this.id = id;
        this.universeId = universeId;
        this.entityName = entityName;
    }

    @Column(name = "ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "universeId", nullable = false)
    @Id
    public Long getUniverseId() {
        return universeId;
    }

    public void setUniverseId(Long universeId) {
        this.universeId = universeId;
    }

    @Column(name = "entityName", nullable = false)
    @Id
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditEntityId)) return false;
        AuditEntityId that = (AuditEntityId) o;
        return getId().equals(that.getId()) && getUniverseId().equals(that.getUniverseId()) && getEntityName().equals(that.getEntityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUniverseId(), getEntityName());
    }
}
