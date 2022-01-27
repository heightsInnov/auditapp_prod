package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditScopeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Api(tags = "AuditScopeEntity API")
public interface AuditScopeEntityController {
    @ApiOperation("Add new data")
    AuditScopeDTO save(@RequestBody AuditScopeDTO auditScopeEntity);

    @ApiOperation("Find by Id")
    AuditScopeDTO findById(@PathVariable("id") BigInteger id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") BigInteger id);

    @ApiOperation("Find all data")
    List<AuditScopeDTO> list();

    @ApiOperation("Pagination request")
    Page<AuditScopeDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    AuditScopeDTO update(@RequestBody AuditScopeDTO dto, @PathVariable("id") BigInteger id);
}