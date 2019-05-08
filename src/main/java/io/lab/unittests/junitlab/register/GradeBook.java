package io.lab.unittests.junitlab.register;

import io.lab.unittests.junitlab.student.Student;
import java.util.LinkedList;
import java.util.List;

public class GradeBook {
    private Student student;
    private List<Integer> grades;

    public GradeBook(Student student) {
        this.student = student;
        this.grades = new LinkedList<Integer>();
    }
    
    public void addGrade(int grade) {
        //TODO: throw an exception when a grade is not between 1 and 6
        grades.add(grade);
    }

    
}
