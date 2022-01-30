package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditUniverseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditUniverse API")
public interface AuditUniverseController {
    @ApiOperation("Add new data")
    public AuditUniverseDTO save(@RequestBody AuditUniverseDTO auditUniverse);

    @ApiOperation("Find by Id")
    public AuditUniverseDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditUniverseDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditUniverseDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditUniverseDTO update(@RequestBody AuditUniverseDTO dto, @PathVariable("id") Long id);
}