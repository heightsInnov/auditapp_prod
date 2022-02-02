package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditScopeApproavalDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditScopeApproaval API")
public interface AuditScopeApproavalController {
    @ApiOperation("Add new data")
    public AuditScopeApproavalDTO save(@RequestBody AuditScopeApproavalDTO auditScopeApproaval);

    @ApiOperation("Find by Id")
    public AuditScopeApproavalDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public boolean delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditScopeApproavalDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditScopeApproavalDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditScopeApproavalDTO update(@RequestBody AuditScopeApproavalDTO dto, @PathVariable("id") Long id);
}