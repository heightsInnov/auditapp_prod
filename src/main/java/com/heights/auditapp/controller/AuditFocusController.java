package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditFocusDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "AuditFocus API")
public interface AuditFocusController {
    @ApiOperation("Add new data")
    public AuditFocusDTO save(@RequestBody AuditFocusDTO auditFocus);

    @ApiOperation("Find by Id")
    public AuditFocusDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<AuditFocusDTO> list();

    @ApiOperation("Pagination request")
    public Page<AuditFocusDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditFocusDTO update(@RequestBody AuditFocusDTO dto, @PathVariable("id") Long id);
}