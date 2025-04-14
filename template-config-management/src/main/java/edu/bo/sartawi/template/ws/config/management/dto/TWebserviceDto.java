package edu.bo.sartawi.template.ws.config.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TWebserviceDto implements Serializable {
    private Integer webserviceId;
    private String code;
    private String description;
    private Boolean enabled;
    private String url;
    private String contentType;
    private String accept;
    private Integer connectTimeout;
    private Integer readTimeout;
    private Integer maxRetry;
    private Integer companyId;
    @JsonIgnore
    private String lastUser;
    @JsonIgnore
    private LocalDateTime lastTime;
}
