package com.tech.apicomerciatech.infrastruture.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.tech.apicomerciatech.application.usecases.ClientService;
import com.tech.apicomerciatech.infrastruture.adapter.mapper.ClientDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.ClienteCreateResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerFunctionalTest {
    @Mock
    private ClientService clientService;

    @Mock
    private ClientDtoMapper clientDtoMapper;

    @InjectMocks
    private ClientController clientController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() { mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();  }

    @Test
    void testUsersCreatePost() throws Exception {
        String clientCreateJson = "{\"name\":\"Test\"}";
        ClientCreate clientCreate = new ClientCreate();
        clientCreate.setName("Test");
        ClienteCreateResponse response = new ClienteCreateResponse();
        response.setName("Test");

        Mockito.when(clientService.save(Mockito.any(ClientCreate.class))).thenReturn(clientCreate);
        Mockito.when(clientDtoMapper.toDbo(Mockito.any(ClientCreate.class))).thenReturn(response);

        mockMvc.perform(post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientCreateJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testUsersIdGet() throws Exception {
        Long id = 1L; // Asume que existe un cliente con ID 1
        ClientSearch clientSearch = new ClientSearch();
        clientSearch.setId(id);

        Mockito.when(clientService.findById(id)).thenReturn(clientSearch);

        mockMvc.perform(get("/api/users/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
