package az.developia.librarysystemfarida.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.model.Book;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.repository.BookRepository;

@Service
public class BookService {



    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> bookSearch(String book) {
        return bookRepository.findByName(book);
    }

	public boolean checkBookExists(Integer bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean borrowBook(Book bookId, Student studentId) {
		// TODO Auto-generated method stub
		return false;
	}
}
