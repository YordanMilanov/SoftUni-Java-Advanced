package StrategyPattern_06;

import java.util.Comparator;
import java.util.Locale;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        if(first.getName().length() == second.getName().length()) {
            char firstPersonChar = first.getName().toLowerCase(Locale.ROOT).charAt(0);
            char secondPersonChar = second.getName().toLowerCase(Locale.ROOT).charAt(0);
            return Character.compare(firstPersonChar, secondPersonChar);
        } else {
           return Integer.compare(first.getName().length(), second.getName().length());
        }
    }
}
