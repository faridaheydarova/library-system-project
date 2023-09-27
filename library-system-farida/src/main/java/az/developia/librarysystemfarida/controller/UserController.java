package az.developia.librarysystemfarida.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.config.MySession;
import az.developia.librarysystemfarida.dto.LoginDTO;
import az.developia.librarysystemfarida.dto.UserDTO;
import az.developia.librarysystemfarida.model.Authority;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.AuthorityRepository;
import az.developia.librarysystemfarida.repository.UserRepo;
import az.developia.librarysystemfarida.response.LoginResponse;
import az.developia.librarysystemfarida.service.UserService;


@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")


public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	

	
	@PreAuthorize("hasRole('LIBRARIAN')")
	@PostMapping(path = "/save")
	public String saveUser(@RequestBody UserDTO userDTO, HttpServletRequest request){ 

		String id = userService.addUser(userDTO);
		request.getSession().invalidate();

	
	Authority authority=new Authority();
	authority.setUsername(userDTO.getUsername());
	authority.setAuthority("LIBRARIAN");
	authorityRepository.save(authority);
	request.getSession().invalidate();
	
	return id;

	}
	
	



	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
	LoginResponse loginResponse = userService.loginUser(loginDTO);
	return ResponseEntity.ok(loginResponse);

	}
	
	@GetMapping
	public List<User> findAll(){
		
		return userRepo.findAll();
		
	}
	
}
