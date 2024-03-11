package com.tech.apicomerciatech.infrastruture.adapter.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClienteCreateResponse;

@Mapper(componentModel = "spring")
public interface ClientDtoMapper {
     @Mapping(source = "name", target = "name")
    ClienteCreateResponse toDbo(ClientCreate client);

    @InheritInverseConfiguration
    ClientCreate toEntity(ClienteCreateResponse dbo);
}
