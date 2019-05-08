package io.lab.unittests.junitlab.student;

public class Student {
    private String firstName;
    private String lastName;
    private int birthYear;
    private int grade;

    Student(String firstName, String lastName, int birthYear, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getGrade() {
        return grade;
    }
}
