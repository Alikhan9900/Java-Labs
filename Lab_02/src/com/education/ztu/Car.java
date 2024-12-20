package com.education.ztu;

public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public class Engine {
        private boolean isWorking = false;

        public void startEngine() {
            isWorking = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            isWorking = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return isWorking;
        }
    }

    @Override
    public String toString() {
        return "Машина{" + "модель='" + model + '\'' + '}';
    }
}