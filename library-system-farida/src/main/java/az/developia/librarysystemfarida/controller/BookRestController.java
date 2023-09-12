package az.developia.librarysystemfarida.controller;

import java.util.List;   



import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

		return bookRepository.findAllByLibrarian(getUser());
	}
	
	
	@PreAuthorize("hasRole('ROLE_LIBRARIAN')")
	@PostMapping(path = "/save")
	public Book addBook(@Valid @RequestBody Book book, BindingResult result) {
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		Optional<Book> bookOptional = bookRepository.findByName(book.getName());
		if (bookOptional.isPresent()) {
			book.setName("Daha öncə bu adla kitab qeydə alınıb!");
			return book;
		} else {
			
			String librarian=SecurityContextHolder.getContext().getAuthentication().getName();
			book.setLibrarian(getUser());
			return bookRepository.save(book);
		}
		
	}
	
	private String getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@GetMapping(path = "/{id}")
	public Book findById(@PathVariable(name = "id") Integer id) {
		return bookRepository.findById(id).get();
	}


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
	    }
	
	
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



