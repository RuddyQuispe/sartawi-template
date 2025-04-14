package edu.bo.sartawi.template.ws.user.management.config.mapper;

import edu.bo.sartawi.template.ws.user.management.dto.TMenuProfileDto;
import edu.bo.sartawi.template.ws.user.management.entity.TMenuProfileEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuProfileMapper {
    TMenuProfileDto mapToDto(TMenuProfileEntity entity);

    TMenuProfileEntity mapToEntity(TMenuProfileDto dto);

    List<TMenuProfileEntity> mapToEntities(List<TMenuProfileDto> dtos);

    List<TMenuProfileDto> mapToDtos(List<TMenuProfileEntity> entities);
}
