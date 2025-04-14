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
public class TProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profileId;
    private String name;
    private String description;
    private Boolean enabled;
    private String lastUser;
    private LocalDateTime lastTime;
}
