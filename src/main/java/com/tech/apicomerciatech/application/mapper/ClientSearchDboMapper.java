package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.openapitools.model.ClientSearch;

@Mapper(componentModel = "spring")
public interface ClientSearchDboMapper {
    ClientSearch toDbo(Client entity);
    @InheritInverseConfiguration
    Client toEntity(ClientSearch dbo);
}
