package edu.bo.sartawi.template.ws.config.management.repository;

import edu.bo.sartawi.template.ws.config.management.entity.TDomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDomainRepository extends JpaRepository<TDomainEntity, Integer> {

    Optional<TDomainEntity> findByCodeAndName(String code, String name);

    List<TDomainEntity> findAllByCode(String code);
}
