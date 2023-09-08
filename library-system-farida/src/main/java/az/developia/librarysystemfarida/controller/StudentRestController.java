package az.developia.librarysystemfarida.controller;

import java.util.List;    
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.dto.LoginDTO;
import az.developia.librarysystemfarida.dto.StudentDTO;
import az.developia.librarysystemfarida.dto.UserDTO;
import az.developia.librarysystemfarida.exception.MyRuntimeException;
import az.developia.librarysystemfarida.model.SearchModel;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.repository.StudentRepo;

import az.developia.librarysystemfarida.response.LoginResponse;
import az.developia.librarysystemfarida.service.StudentService;
import az.developia.librarysystemfarida.service.UserService;
 

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {
	
	
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping(path = "/save")
	public String saveStudent(@Valid @RequestBody StudentDTO studentDTO, BindingResult result){ 
		if(result.hasErrors()) {
			throw new MyRuntimeException(result);
		}
		String librarian=SecurityContextHolder.getContext().getAuthentication().getName();
	
		
		studentDTO.setEmail(getUser());
	String id = studentService.addStudent(studentDTO);
	return id;
	}

	@PostMapping(path="/login")
	public ResponseEntity<?> loginStudent(@RequestBody LoginDTO loginDTO){
	LoginResponse loginResponse = studentService.loginStudent(loginDTO);
	return ResponseEntity.ok(loginResponse);

	}
	
	@GetMapping(path="/{id}")
	public List<Student> findAll(){
		
		return studentRepo.findAll();
		
	}
	
	private String getUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@PostMapping(path="/search")
	public List<Student> findAllSearch(@RequestBody SearchModel search) {
		
		return studentService.findAllSearchAllFields(search.getSearch());
	}
	
	
	@DeleteMapping(path = "/{id}") 

	public void deleteById(@PathVariable Integer id) {

		studentService.deleteById(id);
	}
	

	@PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable Integer id, @RequestBody Student student) {
        if (!studentService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        student.setId(id);
        student = studentRepo.save(student);
        
        return ResponseEntity.ok(student);
    }
	
}

