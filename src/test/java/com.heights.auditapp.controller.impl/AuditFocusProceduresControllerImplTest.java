package com.heights.auditapp.controller.impl;

import com.heights.auditapp.controller.CustomUtils;
import com.heights.auditapp.mapper.AuditFocusProceduresMapper;
import com.heights.auditapp.mapper.ReferenceMapper;
import com.heights.auditapp.model.AuditFocusProcedures;
import com.heights.auditapp.service.AuditFocusProceduresService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AuditFocusProceduresControllerImplTest {
    //TODO: create the data Test generator class AuditFocusProceduresBuilder
    private static final String ENDPOINT_URL = "/audit-focus-proceduress";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AuditFocusProceduresControllerImpl auditfocusproceduresController;
    @MockBean
    private AuditFocusProceduresService auditfocusproceduresService;
    @MockBean
    private AuditFocusProceduresMapper auditfocusproceduresMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.auditfocusproceduresController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(auditfocusproceduresMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AuditFocusProceduresBuilder.getListDTO());

        Mockito.when(auditfocusproceduresService.findAll()).thenReturn(AuditFocusProceduresBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(auditfocusproceduresMapper.asDTO(ArgumentMatchers.any())).thenReturn(AuditFocusProceduresBuilder.getDTO());

        Mockito.when(auditfocusproceduresService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AuditFocusProceduresBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(auditfocusproceduresService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(auditfocusproceduresService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(auditfocusproceduresMapper.asEntity(ArgumentMatchers.any())).thenReturn(AuditFocusProceduresBuilder.getEntity());
        Mockito.when(auditfocusproceduresService.save(ArgumentMatchers.any(AuditFocusProcedures.class))).thenReturn(AuditFocusProceduresBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(AuditFocusProceduresBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(auditfocusproceduresService, Mockito.times(1)).save(ArgumentMatchers.any(AuditFocusProcedures.class));
        Mockito.verifyNoMoreInteractions(auditfocusproceduresService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(auditfocusproceduresMapper.asEntity(ArgumentMatchers.any())).thenReturn(AuditFocusProceduresBuilder.getEntity());
        Mockito.when(auditfocusproceduresService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AuditFocusProceduresBuilder.getEntity());

        mockMvc.perform(
                MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(CustomUtils.asJsonString(AuditFocusProceduresBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(auditfocusproceduresService, Mockito.times(1)).update(ArgumentMatchers.any(AuditFocusProcedures.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(auditfocusproceduresService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(auditfocusproceduresService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(auditfocusproceduresService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(auditfocusproceduresService);
    }