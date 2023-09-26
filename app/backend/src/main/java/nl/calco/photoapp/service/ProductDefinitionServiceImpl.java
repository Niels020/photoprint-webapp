package nl.calco.photoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.calco.photoapp.entity.ProductDefinition;
import nl.calco.photoapp.exception.EntityNotFoundException;
import nl.calco.photoapp.repository.ProductDefinitionRepository;

@AllArgsConstructor
@Service
public class ProductDefinitionServiceImpl implements ProductDefinitionService {
    
    ProductDefinitionRepository productDefinitionRepository;

    @Override
    public ProductDefinition getProductDefinition(Long id) {
        Optional<ProductDefinition> productDefinition = productDefinitionRepository.findById(id);
        return unwrapProductDefinition(productDefinition, id);
    }

    @Override
    public ProductDefinition saveProductDefinition(ProductDefinition productDefinition) {
        return productDefinitionRepository.save(productDefinition);
    }

    @Override
    public void deleteProductDefinition(Long id) {
        if (productDefinitionRepository.existsById(id)) {
            productDefinitionRepository.deleteById(id);
        } else throw new EntityNotFoundException(id, ProductDefinition.class); 
    }

    @Override
    public List<ProductDefinition> getProductDefinitions() {
        return (List<ProductDefinition>) productDefinitionRepository.findAll();
    }

    static ProductDefinition unwrapProductDefinition(Optional<ProductDefinition> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, ProductDefinition.class);
    }
}
