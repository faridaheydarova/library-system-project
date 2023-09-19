package az.developia.librarysystemfarida.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;
    
   
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "borrow_date")
    private Date borrowDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private Date returnDate;
    



	public Borrow() {
		
	}

	public Borrow(Integer id, Book bookId, Student studentId, Date borrowDate, Date returnDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.studentId = studentId;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Book getBook() {
		return bookId;
	}

	public void setBook(Book bookId) {
		this.bookId = bookId;
	}

	public Student getStudent() {
		return studentId;
	}

	public void setStudent(Student student) {
		this.studentId = student;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}



	

	

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", bookId=" + bookId + ", studentId=" + studentId + ", borrowDate=" + borrowDate
				+ ", returnDate=" + returnDate + "]";
	}

	public void setBookId(Integer bookId) {
		// TODO Auto-generated method stub
		
	}
	
	public void setStudentId(Integer studentId) {
		   
	}

	public void setBook(Integer bookId) {
		// TODO Auto-generated method stub
		
	}


	
    

    
    
    

	

   
    
}

