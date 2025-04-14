package edu.bo.sartawi.template.ws.config.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TDomainDto implements Serializable {
    private Integer domainId;
    private String code;
    private String name;
    private String value;
    private String description;
    @JsonIgnore
    private String lastUser;
    @JsonIgnore
    private LocalDateTime lastTime;
}
