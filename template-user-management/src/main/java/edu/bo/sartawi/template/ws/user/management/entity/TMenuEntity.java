package edu.bo.sartawi.template.ws.user.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "t_menu")
@Accessors(fluent = true)
public class TMenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;
    private String name;
    private String route;
    private String icon;
    private Boolean enabled;
    private Integer parentMenuId;
    private String lastUser;
    private LocalDateTime lastTime;
}
