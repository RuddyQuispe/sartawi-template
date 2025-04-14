package edu.bo.sartawi.template.ws.user.management.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(fluent = true)
public class TMenuProfileDto implements Serializable {
    private Integer menuProfileId;
    private Integer menuId;
    private Integer profileId;
    private Boolean enabled;
    private Boolean canUpdate;
    private Boolean canCreate;
    private Boolean canRead;
    private String lastUser;
    private LocalDateTime lastTime;
}
