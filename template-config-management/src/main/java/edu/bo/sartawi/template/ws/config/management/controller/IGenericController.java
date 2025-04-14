package edu.bo.sartawi.template.ws.config.management.controller;

import edu.bo.sartawi.template.ws.config.management.spec.IGenericService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class IGenericController<DTO, ID> {

    protected Logger LOGGER;
    protected final IGenericService<DTO, ID> service;

    public IGenericController(IGenericService<DTO, ID> service) {
        this.service = service;
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DTO> findById(@PathVariable ID id) throws Exception {
        String session = UUID.randomUUID().toString();
        LOGGER.log(Level.INFO, "[{0}] findById request:", new Object[]{session});
        DTO result = this.service.findById(id)
                .orElseThrow(() -> new Exception("No existe resultado con id: " + id));
        LOGGER.log(Level.INFO, "[{0}] findById response: {1}", new Object[]{session, result});
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DTO> save(@RequestBody @Valid DTO dto) throws Exception {
        String session = UUID.randomUUID().toString();
        LOGGER.log(Level.INFO, "[{0}] save request:", new Object[]{session});
        DTO result = this.service.save(dto);
        LOGGER.log(Level.INFO, "[{0}] save response: {1}", new Object[]{session, dto});
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) throws Exception {
        String session = UUID.randomUUID().toString();
        LOGGER.log(Level.INFO, "[{0}] update request:", new Object[]{session});
        DTO result = this.service.update(dto);
        LOGGER.log(Level.INFO, "[{0}] update response: {1}", new Object[]{session, dto});
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable ID id) {
//        service.deleteById(id);
//    }
}
