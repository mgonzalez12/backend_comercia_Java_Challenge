package com.tech.apicomerciatech.infrastruture.adapter;

import com.tech.apicomerciatech.domain.port.ClientPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientJpaAdapter implements ClientPersistencePort {
    private final ClientRepository clientRepository;

    public ClientJpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }
}
