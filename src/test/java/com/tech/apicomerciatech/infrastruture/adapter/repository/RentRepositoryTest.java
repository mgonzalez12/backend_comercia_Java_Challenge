package com.tech.apicomerciatech.infrastruture.adapter.repository;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentRepositoryTest {
    @Mock
    private RentRepository rentRepository;

    @Test
    void testSaveRent() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentRepository.save(rent)).thenReturn(rent);
        Rent result = rentRepository.save(rent);
        assertEquals(rent, result);
    }

    @Test
    void testFindRentById() {
        Rent rent = new Rent();
        rent.setId(1L);

        when(rentRepository.findById(1L)).thenReturn(Optional.of(rent));
        Rent result = rentRepository.findById(1L).orElse(null);
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
        List<Rent> result = rentRepository.findByCliente(cliente);
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
        List<Rent> result = rentRepository.findByCliente_Id(1L);
        assertEquals(Arrays.asList(rent), result);
    }
}