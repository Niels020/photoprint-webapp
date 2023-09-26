package nl.calco.photoapp.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.CustomerAddress;
import nl.calco.photoapp.service.CustomerAddressService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/customer_address")
public class CustomerAddressController {
    
    CustomerAddressService customerAddressService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAddress> getCustomerAddress(@PathVariable Long id) {
        return new ResponseEntity<>(customerAddressService.getCustomerAddress(id), HttpStatus.OK);
    }

    @PostMapping("/customer/{customerId}")
    public ResponseEntity<CustomerAddress> saveAddress(@RequestBody @Valid CustomerAddress customerAddress, @PathVariable Long customerId) {
        return new ResponseEntity<>(customerAddressService.saveCustomerAddress(customerAddress, customerId), HttpStatus.CREATED);
    }
       
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomerAddress(@PathVariable Long id) {
        customerAddressService.deleteCustomerAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddresses() {
        return new ResponseEntity<>(customerAddressService.getAllCustomerAddresses(), HttpStatus.OK);
    } 
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerAddress>> getAllCustomerAddressesByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerAddressService.getAllCustomerAddressesByCustomerId(customerId), HttpStatus.OK);
    }  

}

