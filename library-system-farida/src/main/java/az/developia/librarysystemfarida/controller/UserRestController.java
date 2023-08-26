package az.developia.librarysystemfarida.controller;

import java.util.List; 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.UserRepository;


@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="*")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String saveUser(@RequestBody User u) {
		userRepository.save(u);
		return u.getUsername();
	}
	//@Autowired
	//private AuthorityRepository authorityRepository;
	
	/*@PostMapping
	public User addUser(@RequestBody User user) {
		Optional<User> userOptional = userRepository.findById(user.getUsername());
		if(userOptional.isPresent()){
			
			user.setUsername("");
			return user;
			}else{
	user.setPassword("{noop}"+user.getPassword());
	user.setEnabled(true);
	User savedUser=userRepository.save(user);

	/*AuthorityModel authority=new AuthorityModel();
	authority.setUsername(user.getUsername());
	authority.setAuthority("teacher");
	authorityRepository.save(authority);

	return savedUser;
	}
	}*/
	
	@GetMapping(path="/login")
	public void login() {
	}
	
	@GetMapping
	public List<User> findAll(){
		return userRepository.findAll();

	}
	
	
}
