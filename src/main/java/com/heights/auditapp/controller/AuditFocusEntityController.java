package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditFocusDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Api(tags = "AuditFocusEntity API")
public interface AuditFocusEntityController {
    @ApiOperation("Add new data")
    AuditFocusDTO save(@RequestBody AuditFocusDTO auditFocusEntity);

    @ApiOperation("Find by Id")
    AuditFocusDTO findById(@PathVariable("id") BigInteger id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") BigInteger id);

    @ApiOperation("Find all data")
    List<AuditFocusDTO> list();

    @ApiOperation("Pagination request")
    Page<AuditFocusDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    AuditFocusDTO update(@RequestBody AuditFocusDTO dto, @PathVariable("id") BigInteger id);
}