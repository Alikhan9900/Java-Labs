package com.education.ztu;
import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Employee extends Person {
    private Car car;

    public Employee(String firstName, String lastName, int age, Location location, Gender gender, Car car) {
        super(firstName, lastName, age, location, gender);
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "Праціваник за машиною: " + car;
    }
}