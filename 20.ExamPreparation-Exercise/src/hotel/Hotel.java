package hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    String name;
    int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
      return roster.removeIf(person -> person.getName().equals(name));
    }

    public Person getPerson(String name, String homeTown) {
        return roster.stream().filter(person -> person.getName().equals(name) && person.getHometown().equals(homeTown)).findFirst().orElse(null);
    }

    public int getCount () {
        return roster.size();
    }

    public String getStatistics () {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:\n",this.name));
        for (Person person : roster) {
            sb.append(person.toString() + "\n");
        }
        return sb.toString();
    }
}
