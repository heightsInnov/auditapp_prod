package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditUniverseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Api(tags = "AuditUniverseEntity API")
public interface AuditUniverseEntityController {
    @ApiOperation("Add new data")
    AuditUniverseDTO save(@RequestBody AuditUniverseDTO auditUniverseEntity);

    @ApiOperation("Find by Id")
    AuditUniverseDTO findById(@PathVariable("id") BigInteger id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") BigInteger id);

    @ApiOperation("Find all data")
    List<AuditUniverseDTO> list();

    @ApiOperation("Pagination request")
    Page<AuditUniverseDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    AuditUniverseDTO update(@RequestBody AuditUniverseDTO dto, @PathVariable("id") BigInteger id);
}