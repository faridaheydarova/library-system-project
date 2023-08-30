package az.developia.librarysystemfarida.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

	  public boolean authenticate(String username, String password) {
	        User user = userRepository.findByUsername(username);
	        return user != null && user.getPassword().equals(password);
	    }
}
