package CarSalesman_05;

public class Engine {

    String model;
    String power;
    String displacement = "n/a";
    String efficiency = "n/a" ;
    //displacements, efficiency optional


    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s", this.model, this.power, this.displacement, this.efficiency);
    }
}
