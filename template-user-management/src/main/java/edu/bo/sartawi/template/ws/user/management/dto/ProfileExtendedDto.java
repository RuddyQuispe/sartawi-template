package edu.bo.sartawi.template.ws.user.management.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public class ProfileExtendedDto extends TProfileDto{
    private List<TMenuProfileDto> menu;
}
