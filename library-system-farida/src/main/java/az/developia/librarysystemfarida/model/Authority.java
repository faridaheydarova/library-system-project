package az.developia.librarysystemfarida.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String authority;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setId(Authority authority2) {
		// TODO Auto-generated method stub
		
	}
	public void setAuthority(String string) {
		// TODO Auto-generated method stub
		
	}

}
