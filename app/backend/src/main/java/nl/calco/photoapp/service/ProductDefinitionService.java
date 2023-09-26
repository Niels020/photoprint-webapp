package nl.calco.photoapp.service;

import java.util.List;

import nl.calco.photoapp.entity.ProductDefinition;

public interface ProductDefinitionService {
    ProductDefinition getProductDefinition(Long id);
    ProductDefinition saveProductDefinition(ProductDefinition productDefinition);
    void deleteProductDefinition(Long customerId);
    List<ProductDefinition> getProductDefinitions();
}
