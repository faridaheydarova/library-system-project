package az.developia.librarysystemfarida.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.developia.librarysystemfarida.model.Book;
import az.developia.librarysystemfarida.model.Borrow;
import az.developia.librarysystemfarida.model.Student;



@Repository
public interface BorrowedBooksRepository extends JpaRepository<Borrow, Integer> {

	Optional<Borrow> findByBookIdAndStudentId(Book bookId, Student studentId);

	List<Borrow> findByStudentId(Student studentId);



	
	
}
