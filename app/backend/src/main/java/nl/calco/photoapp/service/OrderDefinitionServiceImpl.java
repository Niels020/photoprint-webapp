package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.CustomerOrder;
import nl.calco.photoapp.entity.OrderDefinition;
import nl.calco.photoapp.entity.ProductDefinition;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.CustomerOrderRepository;
import nl.calco.photoapp.repository.OrderDefinitionRepository;
import nl.calco.photoapp.repository.ProductDefinitionRepository;

@AllArgsConstructor
@Service
public class OrderDefinitionServiceImpl implements OrderDefinitionService {
    
    OrderDefinitionRepository orderDefinitionRepository;
    CustomerOrderRepository customerOrderRepository;
    ProductDefinitionRepository productDefinitionRepository;

    @Override
    public OrderDefinition getOrderDefinition(Long id) {
        Optional<OrderDefinition> orderDefinition = orderDefinitionRepository.findById(id);
        return unwrapOrderDefinition(orderDefinition, id);
    }

    @Override
    public OrderDefinition saveOrderDefinition(OrderDefinition orderDefinition, Long customerOrderId, Long productDefinitionId) {
        CustomerOrder customerOrder = customerOrderRepository.findById(customerOrderId).get();
        ProductDefinition productDefinition = productDefinitionRepository.findById(productDefinitionId).get();
        orderDefinition.setCustomerOrder(customerOrder);
        orderDefinition.setProductDefinition(productDefinition);
        return orderDefinitionRepository.save(orderDefinition);
    }

    @Override
    public List<OrderDefinition> getAllOrderDefinitionsByCustomerOrderId(Long customerOrderId) {
        return (List<OrderDefinition>) orderDefinitionRepository.findByCustomerOrderId(customerOrderId);
    }

    static OrderDefinition unwrapOrderDefinition(Optional<OrderDefinition> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, OrderDefinition.class);
    }
}
