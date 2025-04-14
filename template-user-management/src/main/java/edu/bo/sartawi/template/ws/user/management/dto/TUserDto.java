package edu.bo.sartawi.template.ws.user.management.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Accessors(fluent = true)
public class TUserDto implements Serializable {
    private Integer userId;
    private String userName;
    private String userLogin;
    private String password;
    private Boolean enabled;
    private Integer profileId;
    @JsonIgnore
    private String lastUser;
    @JsonIgnore
    private LocalDateTime lastTime;
}
