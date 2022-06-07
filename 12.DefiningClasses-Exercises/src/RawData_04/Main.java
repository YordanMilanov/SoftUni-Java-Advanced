package RawData_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is < 1
        // if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250


        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carPark = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);

            Cargo cargo = new Cargo(cargoWeight, cargoType);

            Engine engine = new Engine(enginePower, engineSpeed);

            List<Tire> tires = new ArrayList<>();
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            tires.add(tire1);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            tires.add(tire2);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            tires.add(tire3);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            tires.add(tire4);

            Car car = new Car(carModel, engine, cargo, tires);
            carPark.add(car);
        }

        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                for (Car car : carPark) {
                    if (car.getCargo().getCargoType().equals("fragile")) {

                        for (Tire tire : car.getTireInformation()) {
                            if (tire.getTirePressure() < 1) {
                                System.out.println(car.toString());
                                break;
                            }
                        }

                    }
                }
                break;
            case "flamable":
                for (Car car : carPark) {
                    if (car.getCargo().getCargoType().equals("flamable")) {
                        if (car.getEngine().getEnginePower() > 250) {
                            System.out.println(car.toString());
                        }
                    }
                }
                break;
        }
    }
}
