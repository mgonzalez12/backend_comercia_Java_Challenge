package com.tech.apicomerciatech.infrastruture.adapter.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.ClientSearch;

@Mapper(componentModel = "spring")
public interface ClientSearchMapper {
    @Mapping(source = "name", target = "name")
    ClientSearch toDbo(Client client);
    @InheritInverseConfiguration
    Client toEntity(ClientSearch dbo);
}
