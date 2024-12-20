package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Main {
    public static void main(String[] args) {

        Car car = new Car("Tesla Model S");
        Car.Engine engine = car.new Engine();
        engine.startEngine();
        System.out.println("Engine status: " + (engine.isEngineWorks() ? "Working" : "Not working"));
        engine.stopEngine();


        Student student = new Student("Коля", "Петренко", 20, Location.URBAN, Gender.MALE, "ZTU");
        Teacher teacher = new Teacher("Лена", "Акименко", 45, Location.SUBURBAN, Gender.FEMALE, car);
        Employee employee = new Employee("Олег", "Бульба", 30, Location.RURAL, Gender.MALE, car);

        student.sayFullName();
        teacher.sayFullName();
        employee.sayFullName();

        System.out.println(student.getOccupation());
        System.out.println(teacher.getOccupation());
        System.out.println(employee.getOccupation());
        if (student instanceof Person) {
            System.out.println("Student є екземпляром Person");
        }

    }
}
