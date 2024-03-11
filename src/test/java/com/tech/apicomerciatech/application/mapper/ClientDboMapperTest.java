package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.model.ClientCreate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientDboMapperTest {

    @Mock
    private ClientDboMapper clientDboMapper;

    @Test
    @DisplayName("Test To Dbo")
    void testToDbo() {
        Client entity = new Client();
        entity.setId(1L);
        ClientCreate dbo = new ClientCreate();
        dbo.setName("Marcos");

        when(clientDboMapper.toDbo(entity)).thenReturn(dbo);
        ClientCreate result = clientDboMapper.toDbo(entity);
        assertEquals(dbo, result);
    }

    @Test
    @DisplayName("Test To Entity")
    void testToEntity() {
        Client entity = new Client();
        entity.setId(1L);
        ClientCreate dbo = new ClientCreate();
        dbo.setName("Marcos");
        when(clientDboMapper.toEntity(dbo)).thenReturn(entity);
        Client result = clientDboMapper.toEntity(dbo);
        assertEquals(entity, result);
    }
}
