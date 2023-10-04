package nl.calco.photoapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.CustomerOrder;
import nl.calco.photoapp.service.CustomerOrderService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/customer_order")
public class CustomerOrderController {

    CustomerOrderService service;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCustomerOrder(id), HttpStatus.OK);
    }

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<CustomerOrder> saveCustomerOrder(@RequestBody @Valid CustomerOrder customerOrder,
            @PathVariable Long customerId) {
        return new ResponseEntity<>(service.saveCustomerOrder(customerOrder, customerId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerOrder> updateFulFilledCustomerOrder(@RequestBody @Valid CustomerOrder customerOrder,
            @PathVariable Long id) {
        return new ResponseEntity<>(service.updateFulFilledCustomerOrder(customerOrder.getFulfilled(), id),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerOrder(@PathVariable Long id) {
        service.deleteCustomerOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders() {
        return new ResponseEntity<>(service.getAllCustomerOrders(), HttpStatus.OK);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerOrder>> getAllCustomerOrdersByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(service.getAllCustomerOrdersByCustomerId(customerId), HttpStatus.OK);
    }

}
