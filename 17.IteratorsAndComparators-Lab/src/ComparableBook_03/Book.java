package ComparableBook_03;

import java.util.List;

public class Book implements Comparable<Book> {


    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = List.of(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public int compareTo(Book otherBook) {
        if(this.getTitle().compareTo(otherBook.getTitle()) == 0) {
            return Integer.compare(this.getYear(), otherBook.getYear());
        }
        return this.getTitle().compareTo(otherBook.getTitle());
    }
}
