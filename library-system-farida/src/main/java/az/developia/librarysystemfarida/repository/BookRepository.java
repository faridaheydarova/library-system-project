package az.developia.librarysystemfarida.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import az.developia.librarysystemfarida.model.Book;


public interface BookRepository  extends JpaRepository<Book, Integer>
{

Optional<Book> findByName(String string);


@Query(value = "SELECT * FROM books WHERE name LIKE %?1%", nativeQuery = true)
public List<Book> findAllSearch(String search);

List<Book> findAllByLibrarian(String librarian);

@Query(value = "SELECT * FROM books WHERE name LIKE %?1% OR description LIKE %?1% OR author LIKE %?1%" , nativeQuery = true)
public List<Book> findAllSearchAllFields(String search);

@Query(value = "SELECT * FROM books WHERE name LIKE %?1% OR description LIKE %?1% OR author LIKE %?1% LIMIT ?2, ?3", nativeQuery = true)
public List<Book> findAllSearchAllFieldsFindPartial(String search, Integer begin, Integer length);


}
