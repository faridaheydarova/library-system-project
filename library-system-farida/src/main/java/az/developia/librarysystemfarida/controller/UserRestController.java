package az.developia.librarysystemfarida.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.model.Authority;
import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.AuthorityRepository;
import az.developia.librarysystemfarida.repository.UserRepository;
import az.developia.librarysystemfarida.service.UserService;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityRepository authorityRepository;


	@PostMapping
	public User addUser(@RequestBody User user) {
		Optional<User> userOptional = userRepository.findById(user.getId());
		if (userOptional.isPresent()) {
			user.setUsername("");
			return user;
		} else {
			user.setPassword("{noop}" + user.getPassword());
			user.setEnabled(true);
			User addUser = userRepository.save(user);
			 Authority authority=new Authority();
			 authority.setUsername(user.getUsername()); authority.setAuthority("librarian");
			 authorityRepository.save(authority);
			 

			return addUser;
		}

	}

	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();

	}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (username == null || password == null) {
            return new ResponseEntity<>("İstifadəçi məlumatlarını daxil edin!", HttpStatus.BAD_REQUEST);
        }

        if (userService.authenticate(username, password)) {
            return new ResponseEntity<>("Uğurlu giriş!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("İstifadəçi adı və ya kod yanlışdır!", HttpStatus.UNAUTHORIZED);
        }
    }

  

}

