package edu.bo.sartawi.template.ws.user.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "t_profile")
@Accessors(fluent = true)
public class TMenuProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuProfileId;
    private Integer menuId;
    private Integer profileId;
    private Integer orderNo;
    private Boolean canUpdate;
    private Boolean canCreate;
    private Boolean canRead;
    private String lastUser;
    private LocalDateTime lastTime;
}
