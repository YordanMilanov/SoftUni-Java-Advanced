package com.softuni.carConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carCollection = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split("\\s+");

            if ( data.length == 1) {
                Car car = new Car(data[0]);
                carCollection.add(car);
            } else if (data.length == 3){
                Car car = new Car(data[0], data[1], Integer.parseInt(data[2]));
                carCollection.add(car);
            }
        }

        carCollection.forEach(Car -> System.out.println(Car.carInfo()));
    }
}
