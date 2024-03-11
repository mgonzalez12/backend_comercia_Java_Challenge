package com.tech.apicomerciatech.application.services;
import com.tech.apicomerciatech.domain.port.RentPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentServiceImplTest {

    @Mock
    private RentPersistencePort rentPersistencePort;

    @InjectMocks
    private RentServiceImpl rentServiceImpl;

    @Test
    @DisplayName("Test Rents Find By Client Id")
    void testFindByClientId() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentPersistencePort.findByClientId(1L)).thenReturn(Arrays.asList(rent));
        List<Rent> result = rentServiceImpl.findByClientId(1L);
        assertEquals(Arrays.asList(rent), result);
    }
}
