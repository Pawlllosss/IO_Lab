package io.lab.unittests.junitlab.student;

public class StudentBuilder {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int grade;

    public Student build() {
        Student student = new Student(firstName, lastName, birthYear, grade);
        
        StudentValidator.validateGrade(student);
        StudentValidator.validateFirstName(student);
        StudentValidator.validateLastName(student);
        
        return student;
    }
    
    public StudentBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public StudentBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder birthYear(int birthYear) {
        this.birthYear = birthYear;
        return this;
    }

    public StudentBuilder grade(int grade) {
        this.grade = grade;
        return this;
    }
}
