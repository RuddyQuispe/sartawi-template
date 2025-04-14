package edu.bo.sartawi.template.ws.user.management.spec;

import edu.bo.sartawi.template.ws.user.management.dto.TMenuProfileDto;
import edu.bo.sartawi.template.ws.user.management.dto.TProfileDto;

import java.util.List;
import java.util.Optional;

public interface IProfileSpec extends IGenericService<TProfileDto, Integer> {
    Optional<TProfileDto> findExtendedByProfileId(Integer profileId) throws Exception;

    List<TMenuProfileDto> findAllMenuByProfileId(Integer profileId) throws Exception;
}
