package io.lab.unittests.junitlab.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.lab.unittests.junitlab.student.entity.Student;
import io.lab.unittests.junitlab.student.entity.StudentBuilder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Disabled;


public class GradeBookTest {
    private GradeBook gradeBook;
    private Student student;
    
    @BeforeEach
    public void setUp() {
        student = new StudentBuilder()
                .firstName("Stefan")
                .lastName("Sztos")
                .birthYear(2009)
                .year(4)
                .build();
    }
    
    @Nested
    @DisplayName("Tests for method getMinGrade")
    class TestsOfMethodGetMinGrade {
        @Test
        public void shouldReturn1WhenGettingMinGradeWithProvidedValues() {
            List<Integer> grades = new LinkedList<Integer>(Arrays.asList(1, 5, 3));
            gradeBook = new GradeBook(student, grades);
            
            int expected = 1;
            assertEquals(expected, gradeBook.getMinGrade());
        }
        
        @Test
        public void shouldThrowNoSuchElementExceptionWhenGettingMinGradeWithoutGrades() {
            gradeBook = new GradeBook(student);

            assertThrows(NoSuchElementException.class,
                    () -> gradeBook.getMinGrade());
        }
    }
    
    @Test
    public void shouldPassWhenAddingCorrectGrade() {
        gradeBook = new GradeBook(student);
        
        gradeBook.addGrade(1);
        gradeBook.addGrade(6);
    }
    
    @Disabled
    @Test
    public void shouldThrowIllegalStateExceptionWhenAddingIncorrectGrade() {
        //TODO: modify addGrade method so test will pass
        gradeBook = new GradeBook(student);
        
        assertThrows(IllegalArgumentException.class,
                () -> gradeBook.addGrade(0));
        
        assertThrows(IllegalArgumentException.class,
                () -> gradeBook.addGrade(7));
    }
    
}
