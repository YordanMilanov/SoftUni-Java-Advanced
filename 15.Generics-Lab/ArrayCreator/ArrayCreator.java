package ArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    //+we need to create an array with this length, and it must be filled with the T item
    public static <T> T[] create(int length, T item) {
        //+ T[] array = new T[length]; this cannot be defined like this because the program does not know
        // how many space it will need (because we don't know what will be the type which we will give later
        // by replacing T with the type that we want, That is why it has to be defined by us.

        T [] array =(T[]) new Object[length];

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }

        return array;
    }

    public static<T> T[] create(Class<T> myClass, int length, T item) {

        T[] array =(T[]) Array.newInstance(myClass, length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}
