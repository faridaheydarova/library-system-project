package az.developia.librarysystemfarida.controller;

import java.util.List;  



import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import az.developia.librarysystemfarida.exception.MyRuntimeException;

import az.developia.librarysystemfarida.model.Book;
import az.developia.librarysystemfarida.model.SearchModel;
import az.developia.librarysystemfarida.repository.BookRepository;
import az.developia.librarysystemfarida.service.BookService;

@RestController
@RequestMapping(path = "/books")
@CrossOrigin(origins = "*")
public class BookRestController {

	@Autowired
	private BookRepository bookRepository;
	
	
	private final BookService bookService;
	
	@GetMapping
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@PostMapping(path = "/save")
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

	@GetMapping(path = "/{id}")
	public Book findById(@PathVariable(name = "id") Integer id) {
		return bookRepository.findById(id).get();
	}

/*	private String getBook() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}*/


	@DeleteMapping(path = "/{id}") 

	public void deleteById(@PathVariable Integer id) {

		bookRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Integer id, @RequestBody Book book) {
        if (!bookRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        book.setId(id);
        book = bookRepository.save(book);
        
        return ResponseEntity.ok(book);
    }
	

	    

	    @Autowired
	    public BookRestController(BookService bookService) {
	        this.bookService = bookService;
	    }/*

	    @GetMapping("/books-search?book=")
	    public ResponseEntity<Optional<Book>> bookSearch(@RequestParam("book") String book) {
	        Optional<Book> findBook = bookService.bookSearch(book);
	        return ResponseEntity.ok(findBook);
	    }*/
	
	
	@PostMapping(path="/search")
	public List<Book> findAllSearch(@RequestBody SearchModel search) {
		
		return bookRepository.findAllSearchAllFields(search.getSearch());
	}
	@PostMapping(path="/search-find-partial")
	public List<Book> findAllSearchFindPartial(@RequestBody SearchModel search ) {
		//return bookDAO.findAllSearch(search.getSearch());
		//return bookDAO.findAllSearchAllFields(search.getSearch());
		return bookRepository.findAllSearchAllFieldsFindPartial(search.getSearch(),search.getBegin(),search.getLength());
	}
	}



