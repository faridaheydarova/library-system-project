package az.developia.librarysystemfarida.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotEmpty(message="Boş qoymaq olmaz")
	@Size(min=2,message="Minimum 2 simvol yazmaq lazımdır")
	@Size(max=30,message="Maksimum 30 simvol yazmaq lazımdır")
	private String name;

	@Size(max=300,message="Maksimum 300 simvol yazmaq lazımdır")
	private String description;
	
	@Min(value=1,message="Minimum 1 yazmaq olar")
	@Max(value=100,message="Maksimum 100 yazmaq olar")
	@NotNull(message="Boş qoymaq olmaz")
	private Double price;

	@Size(max=30,message="Maksimum 30 simvol yazmaq lazımdır")
	private String author;
	@Min(value=0,message="Minimum 0 yazmaq olar")
	@Max(value=10000,message="Maksimum 10000 yazmaq olar")
	private Integer pageCount;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Book(Integer id,
			@NotEmpty(message = "Boş qoymaq olmaz") @Size(min = 2, message = "Minimum 2 simvol yazmaq lazımdır") @Size(max = 30, message = "Maksimum 30 simvol yazmaq lazımdır") String name,
			@Size(max = 300, message = "Maksimum 300 simvol yazmaq lazımdır") String description,
			@Min(value = 1, message = "Minimum 1 yazmaq olar") @Max(value = 100, message = "Maksimum 100 yazmaq olar") @NotNull(message = "Boş qoymaq olmaz") Double price,
			@Size(max = 30, message = "Maksimum 30 simvol yazmaq lazımdır") String author,
			@Min(value = 0, message = "Minimum 0 yazmaq olar") @Max(value = 10000, message = "Maksimum 10000 yazmaq olar") Integer pageCount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.author = author;
		this.pageCount = pageCount;
	}
	
	public Book() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", author="
				+ author + ", pageCount=" + pageCount + "]";
	}





	   
}
