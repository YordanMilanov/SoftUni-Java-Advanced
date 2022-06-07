package PokemonTrainer_06;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> collectionOfPokemons;


    public Trainer(String name, List<Pokemon> collectionOfPokemons) {
        this.name = name;
        this.collectionOfPokemons = collectionOfPokemons;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getCollectionOfPokemons() {
        return collectionOfPokemons;
    }

    public void setCollectionOfPokemons(List<Pokemon> collectionOfPokemons) {
        this.collectionOfPokemons = collectionOfPokemons;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public Trainer(String name) {
        this.name = name;
        this.collectionOfPokemons = new ArrayList<>();
    }
}
