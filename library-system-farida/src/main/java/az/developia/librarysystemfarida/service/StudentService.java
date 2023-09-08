/*package az.developia.librarysystemfarida.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;


}
*/

package az.developia.librarysystemfarida.service;

import java.util.List;

import az.developia.librarysystemfarida.dto.LoginDTO;
import az.developia.librarysystemfarida.dto.StudentDTO;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.response.LoginResponse;

public interface StudentService {

	String addStudent(StudentDTO studentDTO);

	LoginResponse loginStudent(LoginDTO loginDTO);

	List<Student> findAllByLibraian(String user);

	List<Student> findAll();


	boolean existsById(Integer id);

	List<Student> findAllSearchAllFields(String search);

	void deleteById(Integer id);
}