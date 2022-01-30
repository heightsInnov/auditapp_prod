package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditScopeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditScope API")
public interface AuditScopeController {
    @ApiOperation("Add new data")
    public AuditScopeDTO save(@RequestBody AuditScopeDTO auditScope);

    @ApiOperation("Find by Id")
    public AuditScopeDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditScopeDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditScopeDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditScopeDTO update(@RequestBody AuditScopeDTO dto, @PathVariable("id") Long id);
}