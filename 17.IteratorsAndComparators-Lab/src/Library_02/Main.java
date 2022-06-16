package Library_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);
       Library library = new Library(bookOne, bookTwo, bookThree);

       //first way
//       for (Book book : library) {
 //           System.out.println(book.getTitle());
  //      }

       //second way
        Iterator<Book> libraryIterator = library.iterator();
       while(libraryIterator.hasNext()) {
           System.out.println(libraryIterator.next().getTitle());
       }
    }
}

