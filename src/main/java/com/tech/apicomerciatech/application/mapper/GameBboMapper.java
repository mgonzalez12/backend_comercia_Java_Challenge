package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.openapitools.model.Game;

@Mapper(componentModel = "spring")
public interface GameBboMapper {
    Game toDbo(Games entity);
    @InheritInverseConfiguration
    Games toEntity(Game dbo);
    Games toDto(Game gameEntity);
}
