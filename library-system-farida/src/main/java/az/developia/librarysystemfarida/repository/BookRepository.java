package az.developia.librarysystemfarida.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.librarysystemfarida.model.Book;


public interface BookRepository  extends JpaRepository<Book, Integer>{


	Optional<Book> findById(Integer id);

	Optional<Book> findByName(String string);
	

}
