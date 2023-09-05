package az.developia.librarysystemfarida.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.model.Student;

import az.developia.librarysystemfarida.repository.StudentRepository;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;

	/*@Autowired
	private StudentService studentService;*/

	
	 
	 
	 @PostMapping
	 @ResponseStatus(HttpStatus.CREATED) public Student save(@RequestBody Student
	  student) { return studentRepository.save(student); }
	 

	@GetMapping
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	/*@PostMapping(path="save")
	public ResponseEntity<String> registerStudent(@RequestBody Student student) {
		try {
			studentService.registerStudent(student);
			return ResponseEntity.ok("Tələbə uğurla qeydiyyatdan keçdi.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Xəta baş verdi: " + e.getMessage());
		}
	}*/
}
