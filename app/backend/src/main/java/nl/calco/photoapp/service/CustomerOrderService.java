package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.CustomerOrder;

public interface CustomerOrderService {
    CustomerOrder getCustomerOrder(Long id);
    CustomerOrder saveCustomerOrder(CustomerOrder customerOrder, Long customerId);
    CustomerOrder updateFulFilledCustomerOrder(String fulFilled, Long id);
    void deleteCustomerOrder(Long id);
    List<CustomerOrder> getAllCustomerOrders();
    List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId);
}
