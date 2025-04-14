package edu.bo.sartawi.template.ws.user.management.repository;

import edu.bo.sartawi.template.ws.user.management.entity.TProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<TProfileEntity, Integer> {
}
