package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.openapitools.model.RentalsGamesItem;
@Mapper(componentModel = "spring")
public interface RentDboMapper {
    RentalsGamesItem toDbo(Rent entity);
    @InheritInverseConfiguration
    Rent toEntity(RentalsGamesItem dbo);
}
