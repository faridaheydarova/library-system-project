package az.developia.librarysystemfarida.repository;

import org.springframework.data.jpa.repository.JpaRepository; 

import az.developia.librarysystemfarida.model.User;



public interface UserRepository extends JpaRepository<User, String>{

}
