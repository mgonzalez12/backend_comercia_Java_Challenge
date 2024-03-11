package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.ClientService;
import com.tech.apicomerciatech.domain.constant.Validations;
import com.tech.apicomerciatech.infrastruture.adapter.mapper.ClientDtoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.ClienteCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ClientControllerTest {

    @InjectMocks
    ClientController clientController;

    @Mock
    ClientService clientService;

    @Mock
    ClientDtoMapper clientDtoMapper;

    @Mock
    Validations validations;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test Users find All - status 200")
    void testUsersCreatePost() {
        ClientCreate clientCreate = new ClientCreate();
        ClienteCreateResponse clienteCreateResponse = new ClienteCreateResponse();
        when(clientService.save(any(ClientCreate.class))).thenReturn(clientCreate);
        when(clientDtoMapper.toDbo(any(ClientCreate.class))).thenReturn(clienteCreateResponse);
        ResponseEntity<ClienteCreateResponse> response = clientController.usersCreatePost(clientCreate);
        verify(validations, times(1)).validateClientRequest(any(ClientCreate.class));
        assertAll(
                () -> assertEquals(response.getStatusCode(), HttpStatus.CREATED),
                () -> assertEquals(response.getBody(), clienteCreateResponse)
        );
    }

    @Test
    @DisplayName("Test Users find By Id - status 200")
    void testUsersIdGet() {
        Long id = 1L;
        ClientSearch clientSearch = new ClientSearch();
        when(clientService.findById(id)).thenReturn(clientSearch);
        ResponseEntity<ClientSearch> response = clientController.usersIdGet(id);
        assertEquals(response.getBody(), clientSearch);
    }

}