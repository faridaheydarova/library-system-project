package az.developia.librarysystemfarida.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import az.developia.librarysystemfarida.model.Book;
import az.developia.librarysystemfarida.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findByName(String studentName);

	//List<Student> findAllSearchAllFields(String search);
	
	@Query(value = "SELECT * FROM students WHERE name LIKE %?1%", nativeQuery = true)
	public List<Student> findAllSearchAllFields(String search);

	



}
