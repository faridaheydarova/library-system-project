package az.developia.librarysystemfarida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.StudentRepository;
import az.developia.librarysystemfarida.repository.UserRepository;

@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins="*")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping
	public Student save(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	@GetMapping
	public List<Student> findAll(){
		return studentRepository.findAll();

	}
}
