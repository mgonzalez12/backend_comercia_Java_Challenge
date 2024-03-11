package com.tech.apicomerciatech.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    private ClientService clientService;

    @Test
    @DisplayName("Test Save ")
    void testSave() {
        ClientCreate create = new ClientCreate();
        create.setName("John Doe");
        when(clientService.save(create)).thenReturn(create);
        ClientCreate result = clientService.save(create);
        assertEquals(create, result);
    }

    @Test
    @DisplayName("Test Find By Id ")
    void testFindById() {
        ClientSearch client = new ClientSearch();
        client.setId(1L);
        when(clientService.findById(1L)).thenReturn(client);
        ClientSearch result = clientService.findById(1L);
        assertEquals(client, result);
    }

    @Test
    @DisplayName("Test Save Client Search")
    void testSaveClienteSearch() {
        ClientSearch create = new ClientSearch();
        create.setId(1L);
        when(clientService.saveClienteSearch(create)).thenReturn(create);
        ClientSearch result = clientService.saveClienteSearch(create);
        assertEquals(create, result);
    }
}
