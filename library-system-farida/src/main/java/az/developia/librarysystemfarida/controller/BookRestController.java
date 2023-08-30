package az.developia.librarysystemfarida.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.exception.MyRuntimeException;
import az.developia.librarysystemfarida.model.Book;

import az.developia.librarysystemfarida.repository.BookRepository;


@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
public class BookRestController {
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> findAll() {
		return bookRepository.findAllByLibrarian(getName());
}

	@GetMapping(path = "/{id}")
	public Book findById(@PathVariable(name = "id") Integer id) {
		return bookRepository.findById(id).get();
	}
	
	@PostMapping(path = "save")
	public Book addBook(@Valid @RequestBody Book book, BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		Optional<Book> bookOptional = bookRepository.findByName(book.getName());
		if (bookOptional.isPresent()) {
			book.setName("");
			return book;
		} else {
			Book b = bookRepository.save(book);
}
		return book;
	}
	

}
