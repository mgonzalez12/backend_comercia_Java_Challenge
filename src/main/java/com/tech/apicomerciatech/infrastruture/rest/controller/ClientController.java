package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.ClientService;
import com.tech.apicomerciatech.domain.constant.Validations;
import com.tech.apicomerciatech.infrastruture.adapter.mapper.ClientDtoMapper;
import org.openapitools.api.UsersApi;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.ClienteCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClientController implements UsersApi {

    private final ClientService clientService;
    private final ClientDtoMapper clientDtoMapper;
    private final Validations validations;

    public ClientController(ClientService clientService, ClientDtoMapper clientDtoMapper, Validations validations) {
        this.clientService = clientService;
        this.clientDtoMapper = clientDtoMapper;
        this.validations = validations;
    }
    @Override
    public ResponseEntity<ClienteCreateResponse> usersCreatePost(ClientCreate clientCreate) {
        validations.validateClientRequest(clientCreate);
        try {
            ClientCreate savedClient = clientService.save(clientCreate);
            ClienteCreateResponse response = clientDtoMapper.toDbo(savedClient);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<ClientSearch> usersIdGet(Long id) {
            ClientSearch clientResponse = clientService.findById(id);
            return ResponseEntity.ok(clientResponse);

    }

}

