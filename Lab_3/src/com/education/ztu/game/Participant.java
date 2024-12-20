package com.education.ztu.game;

import java.util.Comparator;
import java.util.Objects;

public abstract class Participant implements Cloneable, Comparable<Participant> {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "Participant{name='" + name + "', age=" + age + '}';
    }

    @Override
    public int compareTo(Participant other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public Participant clone() {
        try {
            return (Participant) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen
        }
    }


    public static Comparator<Participant> ageComparator = Comparator.comparingInt(Participant::getAge);


    public static Comparator<Participant> nameAndAgeComparator =
            Comparator.comparing(Participant::getName).thenComparingInt(Participant::getAge);
}
