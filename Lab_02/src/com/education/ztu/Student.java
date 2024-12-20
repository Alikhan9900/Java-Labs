package com.education.ztu;
import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Student extends Person {
    private String university;

    public Student(String firstName, String lastName, int age, Location location, Gender gender, String university) {
        super(firstName, lastName, age, location, gender);
        this.university = university;
    }

    @Override
    public String getOccupation() {
        return "Студент в " + university;
    }
}