package edu.bo.sartawi.template.ws.config.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
//@EnableCaching
public class WsConfigManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsConfigManagementApplication.class, args);
    }

}
