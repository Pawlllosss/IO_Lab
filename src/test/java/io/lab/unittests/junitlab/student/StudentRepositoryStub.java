package io.lab.unittests.junitlab.student;

import io.lab.unittests.junitlab.student.entity.Student;
import io.lab.unittests.junitlab.student.entity.StudentBuilder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StudentRepositoryStub implements StudentRepository {
    @Override
    public List<Student> getAllStudents() {
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
        
        return students;
    }
}
