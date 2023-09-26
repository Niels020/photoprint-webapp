package nl.calco.photoapp.repository;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>  {
    
}
