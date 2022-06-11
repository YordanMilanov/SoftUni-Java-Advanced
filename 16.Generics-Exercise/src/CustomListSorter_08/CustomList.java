package CustomListSorter_08;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    //customList -> collects information in list
    private List<T> elements;

    //constructor
    public CustomList () {
        this.elements = new ArrayList<>();
    }



    //add method
    public void add (T element) {
        this.elements.add(element);
    }

    //remove method
    public T remove (int index) {
        return this.elements.remove(index);
    }

    //contains method
    public boolean contains(T element) {
        return this.elements.contains(element);
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

    //get max method
    public T getMax () {
        //this.element(this is the list).stream(this is the iteration)
        //.max(this is the method which compares all numbers).get(returns the max value)
        return this.elements.stream().max((e1, e2) -> e1.compareTo(e2)).get();
    }

    //get min method
    public T getMin () {
        return this.elements.stream().min((e1,e2) -> e1.compareTo(e2)).get();
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
            if (elementInList.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    //print method
    public void print() {
        for (T element : this.elements) {
            System.out.println(element);
        }
    }

    //extends the CustomList from task 7th by adding additional method
    //sort method
    public void sort() {
        this.elements.sort(Comparable::compareTo);
    }
}
