package com.tech.apicomerciatech.infrastruture.adapter.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClienteCreateResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientDtoMapperTest {

    @Mock
    private ClientDtoMapper clientDtoMapper;

    @Test
    void testClientDtoMapper() {
        ClientCreate client = new ClientCreate();
        client.setName("John Doe");
        ClienteCreateResponse dbo = new ClienteCreateResponse();
        dbo.setName("John Doe");

        when(clientDtoMapper.toDbo(client)).thenReturn(dbo);
        when(clientDtoMapper.toEntity(dbo)).thenReturn(client);

        assertEquals(dbo, clientDtoMapper.toDbo(client));
        assertEquals(client, clientDtoMapper.toEntity(dbo));
    }

}