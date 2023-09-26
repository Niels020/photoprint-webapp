package nl.calco.photoapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.OrderDefinition;
import nl.calco.photoapp.service.OrderDefinitionService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/order_definition")
public class OrderDefinitionController {
    
    OrderDefinitionService orderDefinitionService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDefinition> getOrderDefinition(@PathVariable Long id) {
        return new ResponseEntity<>(orderDefinitionService.getOrderDefinition(id), HttpStatus.OK);
    }

    @PostMapping("/customer_order/{customerOrderId}/product_definition/{productDefinitionId}")
    public ResponseEntity<OrderDefinition> saveOrderDefinition(@RequestBody @Valid OrderDefinition orderDefinition, @PathVariable Long customerOrderId, @PathVariable Long productDefinitionId) {
        return new ResponseEntity<>(orderDefinitionService.saveOrderDefinition(orderDefinition, customerOrderId, productDefinitionId), HttpStatus.CREATED);
    }

    @GetMapping("/customer_order/{customerOrderId}")
    public ResponseEntity<List<OrderDefinition>> getAllOrderDefinitionsByCustomerOrderId(@PathVariable Long customerOrderId) {
        return new ResponseEntity<>(orderDefinitionService.getAllOrderDefinitionsByCustomerOrderId(customerOrderId), HttpStatus.OK);
    }
}
