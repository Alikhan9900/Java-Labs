package com.education.ztu;

public interface Human {
    void sayFullName();
    void sayAge();
    void sayLocation();
    void sayGender();

    default void whoIAm() {
        System.out.println("Я - людина)");
    }
}
