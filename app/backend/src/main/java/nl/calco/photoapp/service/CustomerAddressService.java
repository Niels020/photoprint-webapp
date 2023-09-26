package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.CustomerAddress;

public interface CustomerAddressService {
    CustomerAddress getCustomerAddress(Long id);
    CustomerAddress saveCustomerAddress(CustomerAddress customerAddress, Long customerId);
    void deleteCustomerAddress(Long id);
    List<CustomerAddress> getAllCustomerAddresses();
    List<CustomerAddress> getAllCustomerAddressesByCustomerId(Long customerId);
}
