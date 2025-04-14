package edu.bo.sartawi.template.ws.user.management.spec;

import edu.bo.sartawi.template.ws.user.management.dto.TUserDto;
import edu.bo.sartawi.template.ws.user.management.dto.UserWithAccessDto;

public interface IUserSpec extends IGenericService<TUserDto, Integer> {
    UserWithAccessDto findWithAccessByUserId(Integer userId) throws Exception;

    UserWithAccessDto saveWithAccess(UserWithAccessDto userAccessDto) throws Exception;

    UserWithAccessDto updateWithAccess(UserWithAccessDto userAccessDto) throws Exception;
}
