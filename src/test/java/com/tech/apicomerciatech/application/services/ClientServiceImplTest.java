package com.tech.apicomerciatech.application.services;

import com.tech.apicomerciatech.application.mapper.ClientDboMapper;
import com.tech.apicomerciatech.application.mapper.ClientSearchDboMapper;
import com.tech.apicomerciatech.application.mapper.RentalsListResponseMapper;
import com.tech.apicomerciatech.domain.port.ClientPersistencePort;
import com.tech.apicomerciatech.domain.port.RentPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.exception.ClientNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.RentalsListResponse;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    @Mock
    private ClientDboMapper clientDboMapper;

    @Mock
    private ClientSearchDboMapper clientSearchDboMapper;

    @Mock
    private ClientPersistencePort clientPersistencePort;

    @Mock
    private RentPersistencePort rentPersistencePort;

    @Mock
    private RentalsListResponseMapper rentalsResponseMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    @DisplayName("Test Save")
    void testSave() {
        ClientCreate create = new ClientCreate();
        Client client = new Client();
        when(clientDboMapper.toEntity(create)).thenReturn(client);
        when(clientPersistencePort.saveClient(client)).thenReturn(client);
        when(clientDboMapper.toDbo(client)).thenReturn(create);
        ClientCreate result = clientService.save(create);
        assertEquals(create, result);
    }

    @Test
    @DisplayName("Test Find By Id")
    void testFindById() {
        Long id = 1L;
        Client client = new Client();
        ClientSearch clientSearch = new ClientSearch();
        Rent rent = new Rent();
        RentalsListResponse rentalsListResponse = new RentalsListResponse();
        when(clientPersistencePort.findById(id)).thenReturn(client);
        when(clientSearchDboMapper.toDbo(client)).thenReturn(clientSearch);
        when(rentPersistencePort.findByClientId(id)).thenReturn(Arrays.asList(rent));
        when(rentalsResponseMapper.toDto(rent)).thenReturn(rentalsListResponse);
        ClientSearch result = clientService.findById(id);
        assertAll(
                () -> assertEquals(clientSearch, result),
                () ->assertEquals(Arrays.asList(rentalsListResponse), result.getRentals())
        );
    }

    @Test
    @DisplayName("Test Find By Id Not Found")
    void testFindByIdNotFound() {
        Long id = 1L;
        when(clientPersistencePort.findById(id)).thenThrow(new EntityNotFoundException());
        assertThrows(ClientNotFoundException.class, () -> clientService.findById(id));
    }

    @Test
    @DisplayName("Test Save Cliente Search")
    void testSaveClienteSearch() {
        ClientSearch update = new ClientSearch();
        Client client = new Client();
        when(clientSearchDboMapper.toEntity(update)).thenReturn(client);
        when(clientPersistencePort.saveClient(client)).thenReturn(client);
        when(clientSearchDboMapper.toDbo(client)).thenReturn(update);
        ClientSearch result = clientService.saveClienteSearch(update);
        assertEquals(update, result);
    }
}
