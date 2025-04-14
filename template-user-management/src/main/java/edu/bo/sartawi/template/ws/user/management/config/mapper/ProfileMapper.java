package edu.bo.sartawi.template.ws.user.management.config.mapper;

import edu.bo.sartawi.template.ws.user.management.dto.TProfileDto;
import edu.bo.sartawi.template.ws.user.management.entity.TProfileEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    TProfileDto mapToDto(TProfileEntity entity);

    TProfileEntity mapToEntity(TProfileDto dto);

    List<TProfileEntity> mapToEntities(List<TProfileDto> dtos);

    List<TProfileDto> mapToDtos(List<TProfileEntity> entities);

}
