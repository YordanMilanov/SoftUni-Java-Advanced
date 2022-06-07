package CarSalesman_05;

public class Car {
    String model;
    Engine engine;
    String weight = "n/a";
    String color = "n/a";

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // weight, color optional


    @Override
    public String toString() {
        return String.format("%s:\n%s\nWeight: %s\nColor: %s",this.model,this.engine.toString(),this.weight, this.color);
    }
}
