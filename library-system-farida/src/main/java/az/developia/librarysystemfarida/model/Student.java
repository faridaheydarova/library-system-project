package az.developia.librarysystemfarida.model;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="students")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.AUTO.IDENTITY)

private Integer id;
@NotEmpty(message="Boş qoymaq olmaz.")
@Size(min=2,message="Minimum 2 simvol yazılmalıdır!")
@Size(max=30,message="Maksimum 30 simvol yazılmalıdır!")
private String name;

@NotEmpty(message="Boş qoymaq olmaz.")
@Size(min=2,message="Minimum 2 simvol yazılmalıdır!")
@Size(max=30,message="Maksimum 30 simvol yazılmalıdır!")
private String email;

private String password;

private String librarian;

public String getLibrarian() {
	return librarian;
}
public void setLibrarian(String librarian) {
	this.librarian = librarian;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public Student(Integer id,
		@NotEmpty(message = "Boş qoymaq olmaz.") @Size(min = 2, message = "Minimum 2 simvol yazılmalıdır!") @Size(max = 30, message = "Maksimum 30 simvol yazılmalıdır!") String name,
		@NotEmpty(message = "Boş qoymaq olmaz.") @Size(min = 2, message = "Minimum 2 simvol yazılmalıdır!") @Size(max = 30, message = "Maksimum 30 simvol yazılmalıdır!") String email,
		String password, String librarian) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.librarian = librarian;
}
public Student() {
	
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", librarian="
			+ librarian + "]";
}






}
