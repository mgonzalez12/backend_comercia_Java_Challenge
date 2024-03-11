package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;

import java.util.List;

public interface RentPersistencePort {

    Rent save(Rent rent);

    Rent findById(Long id);

    List<Rent> findByCliente(Client cliente);

    List<Rent> findByClientId(Long clientId);
}
