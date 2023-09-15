package az.developia.librarysystemfarida.service.impl;

import java.util.List;
import java.util.Optional;  


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.dto.LoginDTO;
import az.developia.librarysystemfarida.dto.StudentDTO;
import az.developia.librarysystemfarida.dto.UserDTO;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.StudentRepo;
import az.developia.librarysystemfarida.repository.UserRepo;
import az.developia.librarysystemfarida.response.LoginResponse;
import az.developia.librarysystemfarida.service.StudentService;
import az.developia.librarysystemfarida.service.UserService;

@Service
public class StudentIMPL  implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public String addStudent(StudentDTO studentDTO) {
		
		Student student = new Student();

		/*userDTO.getId();
		userDTO.getUsername();
		userDTO.getEmail();
		*/
		
		student.setId(studentDTO.getId());
		student.setName(studentDTO.getName());
		student.setEmail(studentDTO.getEmail());

		String encryptedPassword = this.passwordEncoder.encode(studentDTO.getPassword());
		student.setPassword(encryptedPassword);


		//this.passwordEncoder.encode(userDTO.getPassword());
		studentRepo.save(student);
		
		return student.getName();
		
}

	@Override
	public LoginResponse loginStudent (LoginDTO loginDTO) {
		
		String msg = "";
		Student s = studentRepo.findByEmail(loginDTO.getEmail());
		if(s != null) {
		String password = loginDTO.getPassword();
		String encodePassword = s.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			
		if(isPwdRight) {
		Optional<Student> student = studentRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
		if(student.isPresent()) {
	
		return new LoginResponse( "Giriş uğurludur!",true);
		}else{
			return new LoginResponse("Giriş uğursuzdur!",  false);
		}
		
		}else {
		return new LoginResponse( "Şifrəni düzgün daxil edin.", false);
		}
		} else {
			return new LoginResponse( "Email düzgün daxil edin",  false);
		}
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAllByLibraian(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteById(Integer id) {
	    
	    studentRepo.deleteById(id);
	}


	@Override
	public List<Student> findAllSearchAllFields(String search) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean existsById(Integer id) {
	    // Kodunuzu buraya ekleyin
		return false;
	}

	@Override
	public boolean checkStudentExists(Long studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}


