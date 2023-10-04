package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.OrderDefinition;

public interface OrderDefinitionService {
    OrderDefinition getOrderDefinition(Long id);

    OrderDefinition saveOrderDefinition(OrderDefinition orderDefinition, Long customerOrderId,
            Long productDefinitionId);

    List<OrderDefinition> getAllOrderDefinitionsByCustomerOrderId(Long customerOrderId);

}
