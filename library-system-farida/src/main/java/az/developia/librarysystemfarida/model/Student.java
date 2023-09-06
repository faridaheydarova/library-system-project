package az.developia.librarysystemfarida.model;

import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


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
private String surname;

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
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}

}
