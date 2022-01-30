package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditEntity API")
public interface AuditEntityController {
    @ApiOperation("Add new data")
    public AuditDTO save(@RequestBody AuditDTO auditEntity);

    @ApiOperation("Find by Id")
    public AuditDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditDTO update(@RequestBody AuditDTO dto, @PathVariable("id") Long id);
}