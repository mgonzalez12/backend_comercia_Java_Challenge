package com.tech.apicomerciatech.application.usecases;

import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;

public interface ClientService {
    ClientCreate save(ClientCreate create);
    ClientSearch findById(Long id);
    ClientSearch saveClienteSearch(ClientSearch create);
}
