package edu.bo.sartawi.template.ws.config.management.config.mapper;

import edu.bo.sartawi.template.ws.config.management.dto.TDomainDto;
import edu.bo.sartawi.template.ws.config.management.entity.TDomainEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DomainMapper {

    TDomainDto mapToDto(TDomainEntity entity);

    TDomainEntity mapToEntity(TDomainDto dto);

    List<TDomainEntity> mapToEntities(List<TDomainDto> dtos);

    List<TDomainDto> mapToDtos(List<TDomainEntity> entities);
}
