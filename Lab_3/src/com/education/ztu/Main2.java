package com.education.ztu;

import com.education.ztu.game.*;

import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        Team<Schoolar> schoolarTeam = new Team<>("Dragon");
        Team<Schoolar> scollarTeam2 = new Team<>("Rozumnyky");


        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        scollarTeam2.addNewParticipant(schoolar3);
        scollarTeam2.addNewParticipant(schoolar4);


        System.out.println("\nSchoolar team sorted by name:");
        schoolarTeam.getParticipants().sort(Participant::compareTo);
        schoolarTeam.getParticipants().forEach(participant -> System.out.println(participant.getName()));


        System.out.println("\nSchoolar team sorted by age:");
        schoolarTeam.getParticipants().sort(Participant.ageComparator);
        schoolarTeam.getParticipants().forEach(participant -> System.out.println(participant.getName()));


        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);


        System.out.println("\nEmployee team sorted by name and age:");
        employeeTeam.getParticipants().sort(Participant.nameAndAgeComparator);
        employeeTeam.getParticipants().forEach(participant -> System.out.println(participant.getName()));

      
        schoolarTeam.playWith(scollarTeam2);
        schoolarTeam.playWith(employeeTeam);
    }
}
