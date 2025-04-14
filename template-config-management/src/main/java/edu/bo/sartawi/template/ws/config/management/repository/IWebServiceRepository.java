package edu.bo.sartawi.template.ws.config.management.repository;

import edu.bo.sartawi.template.ws.config.management.entity.TWebServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWebServiceRepository  extends JpaRepository<TWebServiceEntity, Integer> {

}
