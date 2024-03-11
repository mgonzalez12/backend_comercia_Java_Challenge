package com.tech.apicomerciatech.infrastruture.adapter.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.ClientSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ClientSearchMapperTest {

    @Mock
    private ClientSearchMapper clientSearchMapper;

    @Test
    void testClientSearchMapper() {
        Client client = new Client();
        client.setName("John Doe");
        ClientSearch dbo = new ClientSearch();
        dbo.setName("John Doe");

        when(clientSearchMapper.toDbo(client)).thenReturn(dbo);
        when(clientSearchMapper.toEntity(dbo)).thenReturn(client);

        assertEquals(dbo, clientSearchMapper.toDbo(client));
        assertEquals(client, clientSearchMapper.toEntity(dbo));
    }

}