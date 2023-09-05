package az.developia.librarysystemfarida.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.UserRepository;

@Service
public class UserService {
	
/*	@Autowired
    private UserRepository userRepository;

	  public boolean authenticate(String username, String password) {
		  Optional<User> userOptional = userRepository.findByUsername(username);
	     
		return username != null && user.getPassword().equals(password);
	      
	     
	    }
}
*/

	    
	    @Autowired
	    private UserRepository userRepository;

	    public boolean authenticate(String username, String password) {
	        Optional<User> userOptional = userRepository.findByUsername(username);
	        
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            return user.getPassword().equals(password);
	        } else {
	          
	            return false;
	        }
	    }
	
}