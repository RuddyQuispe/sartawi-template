package edu.bo.sartawi.template.ws.user.management.repository;

import edu.bo.sartawi.template.ws.user.management.entity.TUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<TUserEntity, Integer> {
}
