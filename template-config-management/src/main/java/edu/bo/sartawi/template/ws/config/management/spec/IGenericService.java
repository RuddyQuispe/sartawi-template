package edu.bo.sartawi.template.ws.config.management.spec;

import java.util.List;
import java.util.Optional;

public interface IGenericService<T, K> {
    T save(T dto) throws Exception;

    T update(T dto) throws Exception;

    Optional<T> findById(K id) throws Exception;

    List<T> findAll() throws Exception;
}
