package com.tech.apicomerciatech.infrastruture.adapter.repository;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientRepositoryTest {
    @Mock
    private ClientRepository clientRepository;

    @Test
    void testSaveClient() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.save(client)).thenReturn(client);
        Client result = clientRepository.save(client);
        assertEquals(client, result);
    }

    @Test
    void testFindClientById() {
        Client client = new Client();
        client.setId(1L);
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Client result = clientRepository.findById(1L).orElse(null);
        assertEquals(client, result);
    }
}