package edu.bo.sartawi.template.ws.config.management.controller;


import edu.bo.sartawi.template.ws.config.management.dto.TDomainDto;
import edu.bo.sartawi.template.ws.config.management.spec.IGenericService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

//@VersionedRestController(version = "v1", resource = "domain")
@RestController
//@RequiredArgsConstructor
@RequestMapping("api/configuration/domain")
public class WsDomain extends IGenericController<TDomainDto, Integer> {

    public WsDomain(IGenericService<TDomainDto, Integer> service) {
        super(service);
        this.LOGGER = Logger.getLogger(WsDomain.class.getName());
    }
}
