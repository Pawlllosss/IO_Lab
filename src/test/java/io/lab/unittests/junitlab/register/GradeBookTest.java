package io.lab.unittests.junitlab.register;

import io.lab.unittests.junitlab.student.Student;
import io.lab.unittests.junitlab.student.StudentBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class GradeBookTest {
    private GradeBook gradeBook;
    
    @BeforeEach
    public void setUp() {
        System.out.println("init");
        Student student = new StudentBuilder()
                .firstName("Stefan")
                .lastName("Sztos")
                .birthYear(2009)
                .grade(4)
                .build();
        
        gradeBook = new GradeBook(student);
    }

    @Test
    public void testShouldNotFailWhenAddingCorrectGrade() {
        System.out.println("Test");
        gradeBook.addGrade(1);
        gradeBook.addGrade(6);
    }
    
    @Test
    public void testShouldThrowIllegalStateExceptionWhenAddingIncorrectGrade() {
        assertThrows(IllegalStateException.class,
                () -> gradeBook.addGrade(0));
        
        assertThrows(IllegalStateException.class,
                () -> gradeBook.addGrade(7));
    }
    
}
