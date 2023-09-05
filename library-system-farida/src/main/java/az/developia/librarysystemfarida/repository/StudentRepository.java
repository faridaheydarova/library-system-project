package az.developia.librarysystemfarida.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.librarysystemfarida.model.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {



}
