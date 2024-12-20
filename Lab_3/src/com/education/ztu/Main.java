package com.education.ztu;

import com.education.ztu.game.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);


        Schoolar clonedSchoolar = (Schoolar) schoolar1.clone();
        System.out.println("Original: " + schoolar1);
        System.out.println("Cloned: " + clonedSchoolar);


        System.out.println("hashCode of Ivan: " + schoolar1.hashCode());
        System.out.println("hashCode of cloned Ivan: " + clonedSchoolar.hashCode());
        System.out.println("Are they equal? " + schoolar1.equals(clonedSchoolar));


        List<Participant> participants = Arrays.asList(
                new Schoolar("Ivan", 13),
                new Schoolar("Mariya", 15),
                new Student("Mykola", 20),
                new Student("Viktoria", 21),
                new Employee("Andriy", 28),
                new Employee("Oksana", 25)
        );


        participants.sort(Participant::compareTo);
        System.out.println("\nParticipants sorted by name:");
        participants.forEach(System.out::println);


        participants.sort(Participant.ageComparator);
        System.out.println("\nParticipants sorted by age:");
        participants.forEach(System.out::println);


        participants.sort(Participant.nameAndAgeComparator);
        System.out.println("\nParticipants sorted by name and age:");
        participants.forEach(System.out::println);
    }
}
