package com.heights.auditapp.controller;

import com.heights.auditapp.dto.AuditUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@Api(tags = "AuditUser API")
public interface AuditUserController {

    @ApiOperation("Add new data")
    String save(AuditUserDTO auditUserDTO, Model model);

    @ApiOperation("Find by Id")
    public AuditUserDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    @GetMapping
    String list(Model model);

    @ApiOperation("Pagination request")
    public Page<AuditUserDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AuditUserDTO update(@RequestBody AuditUserDTO dto, @PathVariable("id") Long id);

    @ApiOperation("Perform Login")
    public AuditUserDTO login(@RequestBody AuditUserDTO dto);
}