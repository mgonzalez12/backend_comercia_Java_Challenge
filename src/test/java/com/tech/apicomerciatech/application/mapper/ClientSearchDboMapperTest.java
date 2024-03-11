package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.ClientSearch;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientSearchDboMapperTest {

    @Mock
    private ClientSearchDboMapper clientSearchDboMapper;

    @Test
    void testClientSearchDboMapper() {
        Client entity = new Client();
        entity.setId(1L);
        ClientSearch dbo = new ClientSearch();
        dbo.setId(1L);

        when(clientSearchDboMapper.toDbo(entity)).thenReturn(dbo);
        when(clientSearchDboMapper.toEntity(dbo)).thenReturn(entity);
        assertAll(
                () -> assertEquals(dbo, clientSearchDboMapper.toDbo(entity)),
                ()-> assertEquals(entity, clientSearchDboMapper.toEntity(dbo))
        );
    }

}