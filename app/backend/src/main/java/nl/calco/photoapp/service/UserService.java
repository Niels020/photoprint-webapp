package nl.calco.photoapp.service;

import nl.calco.photoapp.entity.User;

public interface UserService {
    User getUser(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
