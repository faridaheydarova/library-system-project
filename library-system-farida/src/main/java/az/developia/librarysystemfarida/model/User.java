package az.developia.librarysystemfarida.model;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String username;
private String email;
private String password;
private Boolean enabled;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Boolean getEnabled() {
	return enabled;
}
public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
}
public static String get(String username2) {
	// TODO Auto-generated method stub
	return null;
}


}


