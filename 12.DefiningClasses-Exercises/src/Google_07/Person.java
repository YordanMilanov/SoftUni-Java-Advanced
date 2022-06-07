package Google_07;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    public Person(Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pokemons) {
        this.company = company;
        this.car = car;
        this.parents = parents;
        this.children = children;
        this.pokemons = pokemons;
    }

    public Person() {
        //тук имаме необходимост от празен конструктор но добавяме всички които са от тип лист, защото ако не ги
        //дефинираме тяхната стойност по default = null, а след това когато искаме да им зададем стойности на тези листове
        //ако са null не можем да добавим нещо към null.
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Company:").append("\n");
        if (company != null) {
            builder.append(company).append("\n");
        }

        builder.append("Car:").append("\n");
        if (car != null) {
            builder.append(car).append("\n");
        }

        builder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append("\n");
        }

        builder.append("Parents:").append("\n");
        for (Parent  parent : parents) {
            builder.append(parent).append("\n");
        }

        builder.append("Children:").append("\n");
        for (Child child : children) {
            builder.append(child).append("\n");
        }
        return builder.toString();
    }
}
