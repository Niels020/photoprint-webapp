package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.Customer;
import nl.calco.photoapp.entity.CustomerAddress;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.CustomerRepository;
import nl.calco.photoapp.repository.CustomerAddressRepository;

@AllArgsConstructor
@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {
    
    CustomerAddressRepository customerAddressRepository;
    CustomerRepository customerRepository;

    @Override
    public CustomerAddress getCustomerAddress(Long id) {
        Optional<CustomerAddress> customerAddress = customerAddressRepository.findById(id);
        return unwrapCustomerAddress(customerAddress, id);
    }

    @Override
    public CustomerAddress saveCustomerAddress(CustomerAddress customerAddress, Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customerAddress.setCustomer(customer);
        return customerAddressRepository.save(customerAddress);
    }

    @Override
    public void deleteCustomerAddress(Long id) {
        if (customerAddressRepository.existsById(id)) {
            customerAddressRepository.deleteById(id);
        } else throw new EntityNotFoundException(id, CustomerAddress.class);
    }

    @Override
    public List<CustomerAddress> getAllCustomerAddresses() {
        return (List<CustomerAddress>) customerAddressRepository.findAll();
    }

    @Override
    public List<CustomerAddress> getAllCustomerAddressesByCustomerId(Long customerId) {
        return (List<CustomerAddress>) customerAddressRepository.findByCustomerId(customerId);
    }

    static CustomerAddress unwrapCustomerAddress(Optional<CustomerAddress> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, CustomerAddress.class);
    }

}

