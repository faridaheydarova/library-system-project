package az.developia.librarysystemfarida.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import az.developia.librarysystemfarida.dto.StudentDTO;
import az.developia.librarysystemfarida.model.Student;


@Repository
@EnableJpaRepositories
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	Optional<Student> findOneByEmailAndPassword(String email, String password);

	Student findByEmail(String email);

	List<Student> findAllByLibrarian(String user);



}
