package io.lab.unittests.junitlab.student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class StudentServiceStubTest {
    StudentService studentService;
    
    @Test
    public void shouldReturnAllStudentsFromDatabaseWhenGetAllStudents() {
       StudentRepository studentRepository = new StudentRepositoryStub();
       studentService = new StudentService(studentRepository);
       
       int expectedSize = 2;
       assertEquals(expectedSize, studentService.getAllStudents().size());
    }
    
}
