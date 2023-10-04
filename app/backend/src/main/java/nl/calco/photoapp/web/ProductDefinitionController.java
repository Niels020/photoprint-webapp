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
import nl.calco.photoapp.entity.ProductDefinition;
import nl.calco.photoapp.service.ProductDefinitionService;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/product_definition")
public class ProductDefinitionController {

    ProductDefinitionService service;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDefinition> getProductDefinition(@PathVariable Long id) {
        return new ResponseEntity<>(service.getProductDefinition(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDefinition> saveProduct(@RequestBody @Valid ProductDefinition productDefinition) {
        return new ResponseEntity<>(service.saveProductDefinition(productDefinition), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProductDefinition(@PathVariable Long id) {
        service.deleteProductDefinition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDefinition>> getProductDefinitions() {
        return new ResponseEntity<>(service.getProductDefinitions(), HttpStatus.OK);
    }
}