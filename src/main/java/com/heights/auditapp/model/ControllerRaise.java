package com.heights.auditapp.model;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@SqlResultSetMapping(
        name = "procedureExceptionMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ControllerRaise.class,
                        columns = {
                                @ColumnResult(name = "universe"),
                                @ColumnResult(name = "entity"),
                                @ColumnResult(name = "focus"),
                                @ColumnResult(name = "process"),
                                @ColumnResult(name = "findings"),
                                @ColumnResult(name = "status"),
                                @ColumnResult(name = "riskRating"),
                                @ColumnResult(name = "recommendation"),
                                @ColumnResult(name = "reference", type = Long.class),
                                @ColumnResult(name = "auditor"),
                                @ColumnResult(name = "scope")
                        }
                )
        }
)
@NamedNativeQuery(name = "getProcessExceptions",
        query = "select row_number() over (order by a.ID) as id, d.UNIVERSE_NAME as universe, c.ENTITY_NAME as entity, " +
                "b.AREA_OF_FOCUS as focus, a.PROCEDURE as process, a.EXCEPTION as findings," +
                " a.EXCEPTION_FLAG as status, a.RISK_RATING as riskRating, " +
                "a.RECOMMENDATION as recommendation, a.ID as reference, e.USERNAME as auditor, f.SCOPE_OF_AUDIT as scope " +
                "from AUDIT_FOCUS_PROCEDURES a, AUDIT_FOCUS b, AUDIT_ENTITY c, AUDIT_UNIVERSE d, AUDIT_USER e, AUDIT_SCOPE f " +
                "where a.FOCUS_ID = b.FOCUS_ID " +
                "and b.SCOPE_ID = f.SCOPE_ID " +
                "and f.ENTITY_ID = c.ENTITY_ID " +
                "and c.UNIVERSE_ID = d.UNIVERSE_ID " +
                "and a.USER_ID = e.USER_ID order by a.DATE_CREATED",
        resultSetMapping = "procedureExceptionMapping")
public class ControllerRaise implements Serializable {
    @Id
    Long id;
    String universe;
    String entity;
    String focus;
    String process;
    String findings;
    String status;
    String riskRating;
    String recommendation;
    Long reference;
    String auditor;
    String scope;

    public ControllerRaise(String universe,
                           String entity,
                           String focus,
                           String process,
                           String findings,
                           String status,
                           String riskRating,
                           String recommendation,
                           Long reference,
                           String auditor,
                           String scope) {
        this.universe = universe;
        this.entity = entity;
        this.focus = focus;
        this.process = process;
        this.findings = findings;
        this.status = status;
        this.riskRating = riskRating;
        this.recommendation = recommendation;
        this.reference = reference;
        this.auditor = auditor;
        this.scope = scope;
    }

    public ControllerRaise(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRiskRating() {
        return riskRating;
    }

    public void setRiskRating(String riskRating) {
        this.riskRating = riskRating;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ControllerRaise that = (ControllerRaise) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1607541677;
    }
}
