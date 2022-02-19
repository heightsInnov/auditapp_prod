package com.heights.auditapp.scheduled;

import com.heights.auditapp.dao.AuditScopeRepository;
import com.heights.auditapp.model.Approval_Status;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Jobber {

    private final AuditScopeRepository auditScopeService;

    public Jobber(AuditScopeRepository auditScopeService) {
        this.auditScopeService = auditScopeService;
    }

    @Scheduled(cron = "0 0 0 * * *")
    private void monitorScopeStarter() {
        auditScopeService.findAllByApprovalStatus(Approval_Status.APPROVED.name())
                .forEach(x -> {
                    if (Approval_Status.APPROVED.name().equals(x.getApprovalStatus())
                            && LocalDate.now().isEqual(x.getAuditStartDate())
                    ) {
                        x.setApprovalStatus(Approval_Status.ACTIVE.name());
                        auditScopeService.save(x);
                    }
                });
    }
}
