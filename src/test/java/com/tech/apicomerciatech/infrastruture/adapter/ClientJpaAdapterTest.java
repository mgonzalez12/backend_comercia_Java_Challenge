package com.tech.apicomerciatech.infrastruture.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ClientJpaAdapterTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientJpaAdapter clientJpaAdapter;

    @Test
    @DisplayName("Test Client Save")
    void testSaveClient() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.save(client)).thenReturn(client);
        Client result = clientJpaAdapter.saveClient(client);
        assertEquals(client, result);
    }

    @Test
    @DisplayName("Test Find By Id ")
    void testFindById() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Client result = clientJpaAdapter.findById(1L);
        assertEquals(client, result);
    }

    @Test
    @DisplayName("Test Find By Id Not Found")
    void testFindByIdNotFound() {
        when(clientRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> clientJpaAdapter.findById(1L));
    }
}
