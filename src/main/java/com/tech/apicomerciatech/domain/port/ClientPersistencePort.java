package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;

public interface ClientPersistencePort {
    Client saveClient(Client client);
    Client findById(Long id);

}
