package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.Customer;
import nl.calco.photoapp.entity.CustomerOrder;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.CustomerRepository;
import nl.calco.photoapp.repository.CustomerOrderRepository;

@AllArgsConstructor
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    
    CustomerOrderRepository customerOrderRepository;
    CustomerRepository customerRepository;

    @Override
    public CustomerOrder getCustomerOrder(Long id) {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findById(id);
        return unwrapCustomerOrder(customerOrder, id);
    }

    @Override
    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder, Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        customerOrder.setCustomer(customer);
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public CustomerOrder updateFulFilledCustomerOrder(String fulfilled, Long id) {
        Optional<CustomerOrder> optionalCustomerOrder = customerOrderRepository.findById(id);
        CustomerOrder customerOrder = unwrapCustomerOrder(optionalCustomerOrder, id);
        customerOrder.setFulfilled(fulfilled);
        return customerOrderRepository.save(customerOrder);
    }

    @Override
    public void deleteCustomerOrder(Long id) {
        if (customerOrderRepository.existsById(id)) {
            customerOrderRepository.deleteById(id);
        } else throw new EntityNotFoundException(id, CustomerOrder.class);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders() {
        return (List<CustomerOrder>) customerOrderRepository.findAll();
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId) {
        return (List<CustomerOrder>) customerOrderRepository.findByCustomerId(customerId);
    }

    static CustomerOrder unwrapCustomerOrder(Optional<CustomerOrder> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, CustomerOrder.class);
    }

}
