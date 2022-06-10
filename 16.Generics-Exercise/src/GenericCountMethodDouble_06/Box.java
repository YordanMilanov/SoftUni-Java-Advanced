package GenericCountMethodDouble_06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
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

    //count elements bigger than the given (input)
    public int countGreaterThan(T element) {
        int count = 0; //number of elements that are greater than the given
        for (T elementInList : this.elements) {
            /*CompareTo method returns 3 values -1, 0, 1
            if F(first) > S(second) -> 1
            if F == S -> 0
            if F < S -> -1
            That is why we equalize it to 1, 0, -1 below
             */
            if (elementInList.compareTo(element) == 1) {
                count++;
            }
        }
        return count;
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