package com.tech.apicomerciatech.infrastruture.adapter.repository;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findByCliente(Client cliente);
    List<Rent> findByCliente_Id(Long clienteId);
}

