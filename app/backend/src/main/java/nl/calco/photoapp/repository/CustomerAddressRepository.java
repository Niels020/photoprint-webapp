package nl.calco.photoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.CustomerAddress;

public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
    List<CustomerAddress> findByCustomerId(Long customerId);
}