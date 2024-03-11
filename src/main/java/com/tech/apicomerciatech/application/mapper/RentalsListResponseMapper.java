package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.openapitools.model.RentalsListResponse;

@Mapper(componentModel = "spring")
public interface RentalsListResponseMapper {

    @Mapping(target = "idJuego", source = "juego.id")
    @Mapping(target = "diasAlquilado", source = "diasAlquiladosSolicitados")
    @Mapping(target = "fechaInicio", source = "fechaInicio")
    @Mapping(target = "fechaFin", source = "fechaFin")
    @Mapping(target = "precioTotalSinRecargo", source = "precioTotal")
    @Mapping(target = "recargoRetraso", source = "recargoRetraso")
    RentalsListResponse toDto(Rent entity);

}
