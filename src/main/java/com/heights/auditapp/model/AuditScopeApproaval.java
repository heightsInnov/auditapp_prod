package com.heights.auditapp.model;

import javax.persistence.*;

@Entity
@Table(name = "AUDIT_SCOPE_APPROAVAL")
public class AuditScopeApproaval {
    @Column(name = "SCOPE_ID")
    private Long scopeId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "AUTHORIZER_ID")
    private Long authorizerId;

    @Column(name = "APPROVE_STATUS")
    private String approveStatus;

    @Column(name = "APPROVAL_COMMENT")
    private String approvalComment;

    @Id
    @Column(name = "APPROVAL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalId;

    public Long getScopeId() {
        return this.scopeId;
    }

    public void setScopeId(Long scopeId) {
        this.scopeId = scopeId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAuthorizerId() {
        return this.authorizerId;
    }

    public void setAuthorizerId(Long authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getApproveStatus() {
        return this.approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApprovalComment() {
        return this.approvalComment;
    }

    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }

    public Long getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
}
