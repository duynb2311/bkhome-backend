package duy.nb.finalproject.demo.repository;

import duy.nb.finalproject.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findById(int id);
}

