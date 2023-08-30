package az.developia.librarysystemfarida.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import az.developia.librarysystemfarida.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {


	Optional<User> findById(String username);

	User findByUsername(String username);

}

