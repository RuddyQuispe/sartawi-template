package edu.bo.sartawi.template.ws.user.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(fluent = true)
public class TProfileDto implements Serializable {
    private Integer profileId;
    private String name;
    private String description;
    private Boolean enabled;

    @JsonIgnore
    private String lastUser;
    @JsonIgnore
    private LocalDateTime lastTime;

    private List<TMenuProfileDto> menu;
}
