package az.developia.librarysystemfarida.service.impl;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.dto.LoginDTO;
import az.developia.librarysystemfarida.dto.UserDTO;
import az.developia.librarysystemfarida.model.User;
import az.developia.librarysystemfarida.repository.UserRepo;
import az.developia.librarysystemfarida.response.LoginResponse;
import az.developia.librarysystemfarida.service.UserService;

@Service
public class UserIMPL  implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public String addUser(UserDTO userDTO) {
		
		User user = new User();

		/*userDTO.getId();
		userDTO.getUsername();
		userDTO.getEmail();
		*/
		
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());

		String encryptedPassword = this.passwordEncoder.encode(userDTO.getPassword());
		user.setPassword(encryptedPassword);


		//this.passwordEncoder.encode(userDTO.getPassword());
	
		
		userRepo.save(user);
		
		return user.getUsername();
		
}

	@Override
	public LoginResponse loginUser (LoginDTO loginDTO) {
		
		String msg = "";
		User user1 = userRepo.findByEmail(loginDTO.getEmail());
		if(user1 != null) {
		String password = loginDTO.getPassword();
		String encodePassword = user1.getPassword();
		Boolean isPwdRight = passwordEncoder.matches(password, encodePassword);
			
		if(isPwdRight) {
		Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodePassword);
		if(user.isPresent()) {
	
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
}


