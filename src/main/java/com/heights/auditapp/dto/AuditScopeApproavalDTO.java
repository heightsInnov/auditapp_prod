package com.heights.auditapp.dto;

public class AuditScopeApproavalDTO extends AbstractDTO<Long> {
    private Long approvalId;
    private Long scopeId;
    private Long userId;
    private Long authorizerId;
    private String approveStatus = "P";
    private String approvalComment;

    public AuditScopeApproavalDTO() {
    }

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