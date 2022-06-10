package GenericBoxOfIntegers_02;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;


    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : elements) {
            builder.append(element.getClass().getName() + ": " + element + "\n");
        }


        return builder.toString();
    }
}