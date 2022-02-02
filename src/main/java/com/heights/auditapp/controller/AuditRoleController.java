package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditRoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditRole API")
public interface AuditRoleController {
    @ApiOperation("Add new data")
    public AuditRoleDTO save(@RequestBody AuditRoleDTO auditRole);

    @ApiOperation("Find by Id")
    public AuditRoleDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public boolean delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditRoleDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditRoleDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditRoleDTO update(@RequestBody AuditRoleDTO dto, @PathVariable("id") Long id);
}