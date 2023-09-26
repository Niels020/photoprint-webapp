package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    List<Customer> getCustomers();
}
