package edu.bo.sartawi.template.ws.user.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "t_user")
@Accessors(fluent = true)
public class TUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String userLogin;
    private String password;
    private Boolean enabled;
    private Integer profileId;
    private String lastUser;
    private LocalDateTime lastTime;
}
