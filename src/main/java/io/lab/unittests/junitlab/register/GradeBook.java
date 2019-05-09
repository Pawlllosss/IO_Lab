package io.lab.unittests.junitlab.register;

import io.lab.unittests.junitlab.student.entity.Student;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class GradeBook {
    private Student student;
    private List<Integer> grades;

    public GradeBook(Student student) {
        this.student = student;
        this.grades = new LinkedList<Integer>();
    }

    public GradeBook(Student student, List<Integer> grades) {
        this.student = student;
        this.grades = grades;
    }
    
    public int getMinGrade() {
        return grades.stream()
                .mapToInt(x -> x)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }
    
//TODO: based on getMinGrade. Create getMaxGrade and tests for it.
    
    public double getAverageGrade() {
        return grades.stream()
                .mapToDouble(x -> x)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }
            
    public void addGrade(int grade) {
        //TODO: throw an exception when a grade is not between 1 and 6
        grades.add(grade);
    }

    
}
