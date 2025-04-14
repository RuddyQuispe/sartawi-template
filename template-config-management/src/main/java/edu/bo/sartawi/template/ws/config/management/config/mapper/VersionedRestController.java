package edu.bo.sartawi.template.ws.config.management.config.mapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping("api-template-config/{version}")
public @interface VersionedRestController {
    String version() default "v1";

    String resource();
}
