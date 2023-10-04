package nl.calco.photoapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.ImageData;

public interface ImageDataRepository extends CrudRepository<ImageData, Long> {
    Optional<ImageData> findByName(String name);
}
