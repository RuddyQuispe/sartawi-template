package edu.bo.sartawi.template.ws.user.management.config.mapper;

import edu.bo.sartawi.template.ws.user.management.dto.TMenuDto;
import edu.bo.sartawi.template.ws.user.management.entity.TMenuEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    TMenuDto mapToDto(TMenuEntity entity);

    TMenuEntity mapToEntity(TMenuDto dto);

    List<TMenuEntity> mapToEntities(List<TMenuDto> dtos);

    List<TMenuDto> mapToDtos(List<TMenuEntity> entities);
}
