package one.digitalinnovation.com.repository;

import one.digitalinnovation.com.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
   O Repository segue o padrão strategy
 */

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
