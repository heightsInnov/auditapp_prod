package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditEntityDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Api(tags = "AuditEntityEntity API")
public interface AuditEntityEntityController {
    @ApiOperation("Add new data")
    AuditEntityDTO save(@RequestBody AuditEntityDTO auditEntityEntity);

    @ApiOperation("Find by Id")
    AuditEntityDTO findById(@PathVariable("id") BigInteger id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") BigInteger id);

    @ApiOperation("Find all data")
    List<AuditEntityDTO> list();

    @ApiOperation("Pagination request")
    Page<AuditEntityDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    AuditEntityDTO update(@RequestBody AuditEntityDTO dto, @PathVariable("id") BigInteger id);
}