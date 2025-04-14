package edu.bo.sartawi.template.ws.user.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Accessors(fluent = true)
public class AccessUserDto implements Serializable {
    private Integer menuId;
    private Integer parentMenuId;
    private Integer orderNo;
    private String name;
    private Boolean canUpdate;
    private Boolean canCreate;
    private Boolean canRead;
    private List<AccessUserDto> subMenu;
}
