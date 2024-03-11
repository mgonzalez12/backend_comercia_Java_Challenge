package com.tech.apicomerciatech.infrastruture.adapter;

import com.tech.apicomerciatech.domain.port.RentPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentJpaAdapter implements RentPersistencePort {

    @Autowired
    private RentRepository rentRepository;
    @Override
    public Rent save(Rent rent) {
        return rentRepository.save(rent);
    }

    @Override
    public Rent findById(Long id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rent> findByCliente(Client cliente) {
        return rentRepository.findByCliente(cliente);
    }

    @Override
    public List<Rent> findByClientId(Long clientId) {
        return rentRepository.findByCliente_Id(clientId);
    }

}
