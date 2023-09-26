package nl.calco.photoapp.repository;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.OpeningHour;

public interface OpeningHourRepository extends CrudRepository<OpeningHour, Long> {
    
}
