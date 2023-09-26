package nl.calco.photoapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer_address")
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "street cannot be blank")
    @Size(min = 5, max = 50, message = "street is too short or long")
    @NonNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotBlank(message = "street number cannot be blank")
    @Size(max = 5, message = "street number is too long")
    @NonNull
    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @NotBlank(message = "area code cannot be blank")
    @Size(min = 3, max = 10, message = "first name is too short or long")
    @NonNull
    @Column(name = "area_code", nullable = false)
    private String areaCode;

    @NotBlank(message = "city cannot be blank")
    @Size(min = 3, max = 30, message = "city is too short or long")
    @NonNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "country cannot be blank")
    @Size(min = 3, max = 30, message = "country is too short or long")
    @NonNull
    @Column(name = "country", nullable = false)
    private String country;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
