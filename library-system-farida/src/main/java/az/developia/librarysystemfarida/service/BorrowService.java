package az.developia.librarysystemfarida.service;

import java.sql.Date;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.librarysystemfarida.model.Book;
import az.developia.librarysystemfarida.model.Borrow;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.repository.BorrowedBooksRepository;


@Service
public class BorrowService {

    @Autowired
    private BorrowedBooksRepository borrowRepository;

    private final Student student;

    @Autowired
    public BorrowService(Student student) {
        this.student = student;
    }
    
    public void borrowBook(Integer bookId, Integer studentId) {
        Borrow record = new Borrow();
        record.setBook(bookId);
        record.setStudentId(studentId);
        record.setBorrowDate(new Date(0, 0, 0)); 
        borrowRepository.save(record);
    }

    public void returnBook(	Book bookId, Student studentId) {

        Optional<Borrow> record = borrowRepository.findByBookIdAndStudentId(bookId, studentId);
        if (record.isPresent()) {
            record.get().setReturnDate(new Date(0, 0, 0)); 
            borrowRepository.save(record.get());
        }
    }
}
