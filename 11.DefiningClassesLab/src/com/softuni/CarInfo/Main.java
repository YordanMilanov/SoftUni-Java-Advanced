package com.softuni.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List <CarInfo> carsCollection = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] data = scanner.nextLine().split("\\s+");
            CarInfo car = new CarInfo();
            car.setBrand(data[0]);
            car.setModel(data[1]);
            car.setHorsePower(Integer.parseInt(data[2]));
            carsCollection.add(car);
        }

        carsCollection.forEach(car -> System.out.println(car.carInfo()));
    }
}
