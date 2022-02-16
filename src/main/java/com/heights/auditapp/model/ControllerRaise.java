package com.heights.auditapp.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@SqlResultSetMapping(
        name = "procedureExceptionMapping",
        classes = {
                @ConstructorResult(
                        targetClass = ControllerRaise.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "universe"),
                                @ColumnResult(name = "entity"),
                                @ColumnResult(name = "focus"),
                                @ColumnResult(name = "process"),
                                @ColumnResult(name = "findings"),
                                @ColumnResult(name = "status"),
                                @ColumnResult(name = "riskRating"),
                                @ColumnResult(name = "recommendation"),
                                @ColumnResult(name = "reference"),
                                @ColumnResult(name = "auditor")
                        }
                )
        }
)
@NamedNativeQuery(name = "getProcessExceptions",
        query = "select row_number() over () as id, d.UNIVERSE_NAME, c.ENTITY_NAME, b.AREA_OF_FOCUS, a.PROCEDURE, a.EXCEPTION, a.EXCEPTION_FLAG, a.RISK_RATING, \n" +
                "a.RECOMMENDATION, a.ID, e.USERNAME, f.SCOPE_OF_AUDIT \n" +
                "from AUDIT_FOCUS_PROCEDURES a, AUDIT_FOCUS b, AUDIT_ENTITY c, AUDIT_UNIVERSE d, AUDIT_USER e, AUDIT_SCOPE f\n" +
                "where a.FOCUS_ID = b.FOCUS_ID\n" +
                "and b.SCOPE_ID = f.SCOPE_ID \n" +
                "and f.ENTITY_ID = c.ENTITY_ID \n" +
                "and c.UNIVERSE_ID = d.UNIVERSE_ID \n" +
                "and a.USER_ID = e.USER_ID ",
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
    String reference;
    String auditor;

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
