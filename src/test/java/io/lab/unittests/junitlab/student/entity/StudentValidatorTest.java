package io.lab.unittests.junitlab.student.entity;

import io.lab.unittests.junitlab.student.entity.StudentValidator;
import io.lab.unittests.junitlab.student.entity.Student;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.assertAll;
import io.lab.unittests.junitlab.student.exception.StudentIncorrectStateException;

public class StudentValidatorTest {
    
    @BeforeAll
    public static void init() {
        System.out.println("Testing StudentValidator");
    }
    
    @Nested
    @DisplayName("Tests for method validateYear")
    class TestsOfMethodGetMinGrade {
        @Test
        public void shouldThrowStudentIcorrectStateExceptionWhenYearBelow1() {
            Student student1 = new Student("Stefan", "Sztos", 1997, 0);
            Student student2 = new Student("Stefan", "Sztos", 1997, -1);


            assertAll(
                () -> assertThrows(StudentIncorrectStateException.class,
                    () -> StudentValidator.validateYear(student1)),
                () -> assertThrows(StudentIncorrectStateException.class,
                    () -> StudentValidator.validateYear(student2))
            );
        }
        
        @Test
        public void shouldPasslWhenYearAboveOrEqual1() {
            Student student1 = new Student("Stefan", "Sztos", 1997, 1);
            Student student2 = new Student("Stefan", "Sztos", 1997, 2);

            StudentValidator.validateYear(student1);
            StudentValidator.validateYear(student2);
        }
        
    }

    //TODO: write tests for validateFirstName
    //TODO: write tests for validateLastName
}
