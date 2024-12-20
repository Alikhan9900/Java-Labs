package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public abstract class Person implements Human {
    private static int counter = 0;

    protected String firstName;
    protected String lastName;
    protected int age;
    protected Location location;
    protected Gender gender;

    static {
        counter = 0;
    }

    {
        firstName = "Олег";
        lastName = "Іванько";
        age = 18;
        location = Location.URBAN;
        gender = Gender.MALE;
        counter++;
    }

    public Person() {
    }

    public Person(String firstName, String lastName, int age, Location location, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.gender = gender;
    }

    public static int getCounter() {
        return counter;
    }

    public static void showCounter() {
        System.out.println("Instances created: " + counter);
    }

    public abstract String getOccupation();

    public String getFullInfo() {
        return String.format("Name: %s %s, Age: %d, Location: %s, Gender: %s",
                firstName, lastName, age, location, gender);
    }

    @Override
    public void sayFullName() {
        System.out.println("Full Name: " + firstName + " " + lastName);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }
}
