package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.ClientJpaAdapter;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientPersistencePortTest {

    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientJpaAdapter clientJpaAdapter;

    @Test
    void testSaveClient() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.save(client)).thenReturn(client);
        Client result = clientJpaAdapter.saveClient(client);
        assertEquals(client, result);
    }

    @Test
    void testFindClientById() {
        Client client = new Client();
        client.setId(1L);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Client result = clientJpaAdapter.findById(1L);

        assertEquals(client, result);
    }

}