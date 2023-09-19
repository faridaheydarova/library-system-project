package az.developia.librarysystemfarida.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.librarysystemfarida.model.Borrow;
import az.developia.librarysystemfarida.model.Student;
import az.developia.librarysystemfarida.repository.BorrowedBooksRepository;


@RestController
@RequestMapping("/borrowed-books")
public class BorrowedBooksController {

    @Autowired
    private BorrowedBooksRepository borrowRepository;

    @GetMapping("/{studentId}")
    public List<Borrow> getBorrowedBooksByStudent(@PathVariable Student studentId) {
        return borrowRepository.findByStudentId(studentId);
    }
}
