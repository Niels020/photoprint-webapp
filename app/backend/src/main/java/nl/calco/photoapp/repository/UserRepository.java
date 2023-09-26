package nl.calco.photoapp.repository;

import org.springframework.data.repository.CrudRepository;

import nl.calco.photoapp.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
