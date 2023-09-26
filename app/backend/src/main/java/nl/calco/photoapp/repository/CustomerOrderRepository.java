package nl.calco.photoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.CustomerOrder;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByCustomerId(Long customerId);
}