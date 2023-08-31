package az.developia.librarysystemfarida.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import az.developia.librarysystemfarida.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findById(String username);
	Optional<User> findByUsername(String username );
	



}

