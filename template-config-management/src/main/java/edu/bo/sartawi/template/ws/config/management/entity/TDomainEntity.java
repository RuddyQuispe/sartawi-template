package edu.bo.sartawi.template.ws.config.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity(name = "t_domain")
public class TDomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domainId;
    @Column(nullable = false)
    private String code;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String value;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String lastUser;
    @Column(nullable = false)
    private LocalDateTime lastTime;

}


