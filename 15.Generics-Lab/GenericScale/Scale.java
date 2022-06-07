package GenericScale;

import java.util.Comparator;

// for this task we must create generics method that can compare variables from different types(not specified)
// to do this we need T to extend Comparable of the T for example if T is String the T extends the Comparable method of String
// if it is Integer it extends the Comparable method of Integer and so on...
// if the T that we give to the class for example if we put Scanner on the place of T it will not work because
// the scanner class does not have a compareTo method, but if the Class has comparable method the it will work.
public class Scale<T extends Comparable<T>> {
   private T left;
   private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {

        if (left.compareTo(right) > 0) {
        return left;
        } else if (right.compareTo(left) > 0) {
            return  right;
        } else {
            return null;
        }
    }
}
