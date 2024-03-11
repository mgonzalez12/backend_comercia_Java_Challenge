package com.tech.apicomerciatech.infrastruture.adapter;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.repository.RentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentJpaAdapterTest {

    @Mock
    private RentRepository rentRepository;

    @InjectMocks
    private RentJpaAdapter rentJpaAdapter;

    @Test
    @DisplayName("Test Rentals Save")
    void testSave() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentRepository.save(rent)).thenReturn(rent);
        Rent result = rentJpaAdapter.save(rent);
        assertEquals(rent, result);
    }

    @Test
    @DisplayName("Test Rentals find By Id ")
    void testFindById() {
        Rent rent = new Rent();
        rent.setId(1L);
        when(rentRepository.findById(1L)).thenReturn(Optional.of(rent));
        Rent result = rentJpaAdapter.findById(1L);
        assertEquals(rent, result);
    }

    @Test
    @DisplayName("Test Rentals find By Client")
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
