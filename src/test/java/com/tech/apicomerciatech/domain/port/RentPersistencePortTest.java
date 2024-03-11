package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.RentJpaAdapter;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.repository.RentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentPersistencePortTest {

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentJpaAdapter rentJpaAdapter;

    @Test
    void testSaveRent() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentRepository.save(rent)).thenReturn(rent);
        Rent result = rentJpaAdapter.save(rent);
        assertEquals(rent, result);
    }

    @Test
    void testFindRentById() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentRepository.findById(1L)).thenReturn(Optional.of(rent));
        Rent result = rentJpaAdapter.findById(1L);
        assertEquals(rent, result);
    }

    @Test
    void testFindByCliente() {
        Client cliente = new Client();
        cliente.setId(1L);
        Rent rent = new Rent();
        rent.setId(1L);
        rent.setCliente(cliente);

        when(rentRepository.findByCliente(cliente)).thenReturn(Arrays.asList(rent));
        List<Rent> result = rentJpaAdapter.findByCliente(cliente);
        assertEquals(Arrays.asList(rent), result);
    }

    @Test
    void testFindByClientId() {
        Client cliente = new Client();
        cliente.setId(1L);
        Rent rent = new Rent();
        rent.setId(1L);
        rent.setCliente(cliente);

        when(rentRepository.findByCliente_Id(1L)).thenReturn(Arrays.asList(rent));
        List<Rent> result = rentJpaAdapter.findByClientId(1L);
        assertEquals(Arrays.asList(rent), result);
    }
}