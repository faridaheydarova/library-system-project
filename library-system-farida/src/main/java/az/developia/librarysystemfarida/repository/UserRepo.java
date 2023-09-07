package az.developia.librarysystemfarida.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import az.developia.librarysystemfarida.model.User;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findOneByEmailAndPassword(String email, String password);

	User findByEmail(String email);

}
