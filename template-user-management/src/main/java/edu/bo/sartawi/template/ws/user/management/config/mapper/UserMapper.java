package edu.bo.sartawi.template.ws.user.management.config.mapper;

import edu.bo.sartawi.template.ws.user.management.dto.TUserDto;
import edu.bo.sartawi.template.ws.user.management.entity.TUserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    TUserDto mapToDto(TUserEntity entity);

    TUserEntity mapToEntity(TUserDto dto);

    List<TUserEntity> mapToEntities(List<TUserDto> dtos);

    List<TUserDto> mapToDtos(List<TUserEntity> entities);
}
