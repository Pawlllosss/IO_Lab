package io.lab.unittests.junitlab.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.lab.unittests.junitlab.student.entity.Student;
import io.lab.unittests.junitlab.student.entity.StudentBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class StudentServiceMockTest {
    StudentService studentService;
    
    @Mock
    StudentRepository studentRepositoryMock;
    
    @Test
    public void shouldReturnAllStudentsFromDatabaseWhenDatabaseContainsStudents() {
       mockStudentRepositoryWithStudents();
       studentService = new StudentService(studentRepositoryMock);
       
       int expectedSize = 2;
       
       assertEquals(expectedSize, studentService.getAllStudents().size());
       Mockito.verify(studentRepositoryMock).getAllStudents();
    }
    
    @Test
    public void shouldReturnNoStudentsWhenDatabaseEmpty() {
       mockStudentRepositoryWithEmptyList();
       studentService = new StudentService(studentRepositoryMock);
        
       int expectedSize = 0;
       
       assertEquals(expectedSize, studentService.getAllStudents().size());
    }
    
    private void mockStudentRepositoryWithStudents() {
        List<Student> students = new LinkedList<Student>();
        Student student1 = new StudentBuilder()
                .firstName("Jacek")
                .lastName("Graniecki")
                .birthYear(1997)
                .year(2)
                .build();
        
        Student student2 = new StudentBuilder()
                .firstName("Adam")
                .lastName("Kowalski")
                .birthYear(1998)
                .year(1)
                .build();
        
        students.addAll(Arrays.asList(student1, student2));
        
        Mockito.when(studentRepositoryMock.getAllStudents())
                .thenReturn(students);
    }    
    
    private void mockStudentRepositoryWithEmptyList() {
        List<Student> students = Collections.emptyList();
        
        Mockito.when(studentRepositoryMock.getAllStudents())
                .thenReturn(students);
    }
}
