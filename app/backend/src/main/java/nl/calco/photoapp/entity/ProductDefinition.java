package nl.calco.photoapp.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_definition")
public class ProductDefinition {


    public ProductDefinition() {
    }

    public ProductDefinition(String name, BigDecimal price, int manufactoringTimeInMinutes) {
        this.name = name;
        this.price = price;
        this.manufactoringTimeInMinutes = manufactoringTimeInMinutes;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Min(0)
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Min(0)
    @Column(name = "manufactoring_time_in_minutes", nullable = false)
    private int manufactoringTimeInMinutes;

    @JsonIgnore
    @OneToMany(mappedBy = "productDefinition", cascade = CascadeType.ALL)
    private List<OrderDefinition> orderDefinitions;
    
}
