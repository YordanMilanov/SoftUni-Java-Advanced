package RawData_04;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String carModel;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tireInformation = new ArrayList<>();

    public Car(String carModel,Engine engine, Cargo cargo, List<Tire> tireInformation) {
        this.carModel = carModel;
        this.engine = engine;
        this.cargo = cargo;
        this.tireInformation = tireInformation;
    }

    @Override
    public String toString() {
        return this.carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public List<Tire> getTireInformation() {
        return tireInformation;
    }
}
