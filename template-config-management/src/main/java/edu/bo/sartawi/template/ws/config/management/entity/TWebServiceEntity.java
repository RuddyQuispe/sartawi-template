package edu.bo.sartawi.template.ws.config.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table
@Entity(name = "t_webservice")
public class TWebServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer webserviceId;
    @Column(nullable = false, unique = true)
    private String code;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Boolean enabled;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false)
    private String contentType;
    @Column(nullable = false)
    private String accept;
    @Column(nullable = false)
    private Integer connectTimeout;
    @Column(nullable = false)
    private Integer readTimeout;
    @Column(nullable = false)
    private Integer maxRetry;
    @Column(nullable = false)
    private Integer companyId;
    @Column(nullable = false)
    private String lastUser;
    @Column(nullable = false)
    private LocalDateTime lastTime;
}
