package nl.calco.photoapp;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import nl.calco.photoapp.entity.Customer;
import nl.calco.photoapp.entity.OpeningHour;
import nl.calco.photoapp.entity.ProductDefinition;
import nl.calco.photoapp.repository.CustomerRepository;
import nl.calco.photoapp.repository.OpeningHourRepository;
import nl.calco.photoapp.repository.ProductDefinitionRepository;

@SpringBootApplication
public class PhotoAppApplication implements CommandLineRunner{

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OpeningHourRepository openingHourRepository;

	@Autowired
	ProductDefinitionRepository productDefinitionRepository;

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApplication.class, args);
	
	}
	// This override run method gives some data to work with for testing with postman and h2 db.
	@Override
	public void run(String... args) throws Exception {

		Customer[] customers = new Customer[] {
			new Customer("Niels", "de Haas", "niels@hotmail.com", "061234223"),
			new Customer("Harry", "Hairy", "hairy@hotmail.com", "0698899888"),
			new Customer("Rosa", "Frenken", "ikhouvanbrokjes@hotmail.com", "063453231"),
			new Customer("Seppertje", "de Haas", "ikbenfluff@gmail.com", "064444323"),
			new Customer("Sonya", "Frenken", "doemaarwat@email.com", "064466771")
		};

		for(int i = 0; i < customers.length; i++) {
			customerRepository.save(customers[i]);
		}

		OpeningHour[] openingHours = new OpeningHour[] {
			new OpeningHour("monday", 540, 1080),
			new OpeningHour("tuesday", 540, 1080),
			new OpeningHour("wednesday", 540, 1080),
			new OpeningHour("thursday", 540, 1080),
			new OpeningHour("friday", 540, 1260),
			new OpeningHour("saturday", 540, 960),
			new OpeningHour("sunday", 0, 0)
		};

		for(int i = 0; i  < openingHours.length; i++) {
			openingHourRepository.save(openingHours[i]);
		}

		ProductDefinition[] productDefinitions = new ProductDefinition[] {
			new ProductDefinition("Paper 10 x 15 mat", new BigDecimal("1.40"), 60),
			new ProductDefinition("Paper 10 x 15 high gloss", new BigDecimal("1.50"), 60),
			new ProductDefinition("Paper 30 x 40 mat", new BigDecimal("4.50"), 120),
			new ProductDefinition("Paper 30 x 40 high gloss", new BigDecimal("5.00"), 120),
			new ProductDefinition("Canvas 30 x 40 mat", new BigDecimal("24.00"), 720),
			new ProductDefinition("Canvas 30 x 40 high gloss", new BigDecimal("27.50"), 720),
			new ProductDefinition("Canvas 100 x 150 mat", new BigDecimal("64.75"), 960),
			new ProductDefinition("Canvas 100 x 150 high gloss", new BigDecimal("72.50"), 960),
			new ProductDefinition("Glass 30 x 40 mat", new BigDecimal("27.50"), 840),
			new ProductDefinition("Glass 30 x 40 high gloss", new BigDecimal("27.50"), 840),
			new ProductDefinition("Glass 100 x 150 mat", new BigDecimal("82.50"), 1200),
			new ProductDefinition("Glass 100 x 150 high gloss", new BigDecimal("82.50"), 1200)
		};

		for(int i = 0; i < productDefinitions.length; i++) {
			productDefinitionRepository.save(productDefinitions[i]);
		}

	}

}
