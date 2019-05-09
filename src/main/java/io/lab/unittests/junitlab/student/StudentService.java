package io.lab.unittests.junitlab.student;

import io.lab.unittests.junitlab.student.entity.Student;
import java.util.List;

public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
}
