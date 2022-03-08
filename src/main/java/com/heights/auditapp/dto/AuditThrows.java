package com.heights.auditapp.dto;

import lombok.Data;

@Data
public class AuditThrows {
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
}
