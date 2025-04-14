package edu.bo.sartawi.template.ws.user.management.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(fluent = true)
public class UserWithAccessDto extends TUserDto {
    List<AccessUserDto> access;
}
