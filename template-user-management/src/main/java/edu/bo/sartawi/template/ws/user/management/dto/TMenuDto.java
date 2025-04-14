package edu.bo.sartawi.template.ws.user.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(fluent = true)
public class TMenuDto implements Serializable {
    private Integer menuId;
    private String name;
    private String route;
    private String icon;
    private Boolean enabled;
    private Integer parentMenuId;
    @JsonIgnore
    private String lastUser;
    @JsonIgnore
    private LocalDateTime lastTime;
}
