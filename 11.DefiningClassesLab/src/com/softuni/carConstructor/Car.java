package com.softuni.carConstructor;

public class Car {
    String brand;
    String model;
    int horsePower;

    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }


    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
