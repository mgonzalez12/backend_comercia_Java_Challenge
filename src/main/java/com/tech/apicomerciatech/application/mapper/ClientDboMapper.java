package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.openapitools.model.ClientCreate;

@Mapper(componentModel = "spring")
public interface ClientDboMapper {

    ClientCreate toDbo(Client entity);
    @InheritInverseConfiguration
    Client toEntity(ClientCreate dbo);
}
