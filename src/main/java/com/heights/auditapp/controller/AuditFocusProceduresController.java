package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditFocusProceduresDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "AuditFocusProcedures API")
public interface AuditFocusProceduresController {
    @ApiOperation("Add new data")
    AuditFocusProceduresDTO save(@RequestBody AuditFocusProceduresDTO auditFocusProcedures);

    @PostMapping
    List<AuditFocusProceduresDTO> save(@RequestBody List<AuditFocusProceduresDTO> auditFocusProceduresDTO, Long focusId);

    @ApiOperation("Find by Id")
    AuditFocusProceduresDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<AuditFocusProceduresDTO> list();

    @GetMapping
    @ResponseBody
    List<AuditFocusProceduresDTO> list(@PathVariable Long focusId);

    @ApiOperation("Pagination request")
    Page<AuditFocusProceduresDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    AuditFocusProceduresDTO update(@RequestBody AuditFocusProceduresDTO dto, @PathVariable("id") Long id);
}