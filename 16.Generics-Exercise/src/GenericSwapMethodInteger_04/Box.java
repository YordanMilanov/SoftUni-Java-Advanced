package GenericSwapMethodInteger_04;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;


    //constructor with an empty array list(otherwise it will throw an exception)
    public Box() {
        this.elements = new ArrayList<>();
    }

    // adds element (method)
    public void add(T element) {
        this.elements.add(element);
    }


    //swaps the elements on the given indexes (method)
    public void swap(int firstIndex, int secondIndex) {
        //takes the elements of the give indexes
        T firstIndexElement = elements.get(firstIndex);
        T secondIndexElement = elements.get(secondIndex);

        //swaps them
        this.elements.set(firstIndex, secondIndexElement);
        this.elements.set(secondIndex, firstIndexElement);
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