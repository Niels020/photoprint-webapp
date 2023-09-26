package nl.calco.photoapp.repository;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.ProductDefinition;

public interface ProductDefinitionRepository extends CrudRepository<ProductDefinition, Long> {
    
}
