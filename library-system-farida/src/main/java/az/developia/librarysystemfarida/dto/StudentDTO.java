package az.developia.librarysystemfarida.dto;

public class StudentDTO {

	private Integer id;
	private String name;
	private String email;
	private String password;
	private String librarian;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibrarian() {
		return librarian;
	}
	public void setLibrarian(String librarian) {
		this.librarian = librarian;
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
	public StudentDTO(Integer id, String name, String email, String password, String librarian) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.librarian = librarian;
	}
	
	
	
	public StudentDTO() {
		
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", librarian=" + librarian + "]";
	}

	
	
}
