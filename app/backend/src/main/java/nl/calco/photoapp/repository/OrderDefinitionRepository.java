package nl.calco.photoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.OrderDefinition;

public interface OrderDefinitionRepository extends CrudRepository<OrderDefinition, Long> {
    List<OrderDefinition> findByCustomerOrderId(Long customerOrderId);
}
