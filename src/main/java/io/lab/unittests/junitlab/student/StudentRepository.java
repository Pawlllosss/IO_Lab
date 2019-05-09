package io.lab.unittests.junitlab.student;

import io.lab.unittests.junitlab.student.entity.Student;
import java.util.List;


public interface StudentRepository {
    List<Student> getAllStudents();
}
