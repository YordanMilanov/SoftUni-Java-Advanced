package CarSalesman_05;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        String[] specs = scanner.nextLine().split("\\s+");
        //displacements, efficiency optional
        for (int i = 0; i < n; i++) {
            String model = specs[0];
            String power = specs[1];

            if (specs.length == 4) {
                String displacement = specs[2];
                String efficiency = specs[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engineList.add(engine);
            } else if (specs.length == 3) {
                boolean numeric = specs[2].matches("-?\\d+(\\.\\d+)?");

                if (numeric) {
                    Engine engine = new Engine(model, power);
                    engineList.add(engine);
                    engine.setDisplacement(specs[2]);
                } else {
                    Engine engine = new Engine(model, power);
                    engineList.add(engine);
                    engine.setEfficiency(specs[2]);
                }
            } else {
                Engine engine = new Engine(model, power);
                engineList.add(engine);
            }
            specs = scanner.nextLine().split("\\s+");
        }
        int m = Integer.parseInt(specs[0]);

        // weight, color optional
        for (int i = 0; i < m; i++) {
            specs = scanner.nextLine().split("\\s+");

            String model = specs[0];
            String engine = specs[1];
            Engine localEngine = null;
            for (Engine engine1 : engineList) {
                if (engine1.getModel().equals(specs[1])) {
                    localEngine = engine1;
                }
            }

            if (specs.length == 4) {
                String weight = specs[2];
                String color = specs[3];


                Car car = new Car(model, localEngine, weight, color);
                cars.add(car);

            } else if (specs.length == 3) {
                boolean numeric = specs[2].matches("-?\\d+(\\.\\d+)?");
               if (numeric) {
                String weight = specs[2];
                Car car = new Car(model, localEngine);
                car.setWeight(weight);
                cars.add(car);
               } else {
                   String color = specs[2];
                   Car car = new Car(model, localEngine);
                   car.setColor(color);
                   cars.add(car);
               }

            } else {
                Car car = new Car(model, localEngine);
                cars.add(car);
            }
        }

        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
