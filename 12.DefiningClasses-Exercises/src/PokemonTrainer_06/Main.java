package PokemonTrainer_06;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        Map<String, Trainer> trainerList = new LinkedHashMap<>();

        while (!data[0].equals("Tournament")) {
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer emptyTrainer = new Trainer(trainerName);
            trainerList.putIfAbsent(trainerName, emptyTrainer);
            for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
                if (entry.getValue().getName().equals(trainerName)) {
                    List<Pokemon> localCollection = entry.getValue().getCollectionOfPokemons();
                    localCollection.add(pokemon);
                    entry.getValue().setCollectionOfPokemons(localCollection);
                }

            }

            data = scanner.nextLine().split("\\s+");
        }

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "Fire":
                    for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
                        boolean hasFire = false;
                        for (Pokemon pokemon : entry.getValue().getCollectionOfPokemons()) {
                            if (pokemon.getElement().equals("Fire")) {
                                hasFire = true;
                                break;
                            }
                        }
                        if (hasFire) {
                            int currentBadgesIncreased = entry.getValue().getNumberOfBadges() + 1;
                            entry.getValue().setNumberOfBadges(currentBadgesIncreased);
                            continue;
                        } else {
                            for (Pokemon poke : entry.getValue().getCollectionOfPokemons()) {
                                int currentHealthDecreased = poke.getHealth() - 10;
                                if (currentHealthDecreased <= 0) {
                                    List<Pokemon> localPokemons = new ArrayList<>(entry.getValue().getCollectionOfPokemons());
                                    localPokemons.remove(poke);
                                    entry.getValue().setCollectionOfPokemons(localPokemons);
                                    break;
                                }
                                poke.setHealth(currentHealthDecreased);
                            }
                        }
                    }
                    break;
                case "Water":
                    for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
                        boolean hasWater = false;
                        for (Pokemon pokemon : entry.getValue().getCollectionOfPokemons()) {
                            if (pokemon.getElement().equals("Water")) {
                                hasWater = true;
                                break;
                            }
                        }
                        if (hasWater) {
                            int currentBadgesIncreased = entry.getValue().getNumberOfBadges() + 1;
                            entry.getValue().setNumberOfBadges(currentBadgesIncreased);
                            continue;
                        } else {
                            for (Pokemon poke : entry.getValue().getCollectionOfPokemons()) {
                                int currentHealthDecreased = poke.getHealth() - 10;
                                if (currentHealthDecreased <= 0) {
                                    List<Pokemon> localPokemons = new ArrayList<>(entry.getValue().getCollectionOfPokemons());
                                    localPokemons.remove(poke);
                                    entry.getValue().setCollectionOfPokemons(localPokemons);
                                    break;
                                }
                                poke.setHealth(currentHealthDecreased);
                            }
                        }
                    }
                    break;
                case "Electricity":
                    for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
                        boolean hasElectricity = false;
                        for (Pokemon pokemon : entry.getValue().getCollectionOfPokemons()) {
                            if (pokemon.getElement().equals("Electricity")) {
                                hasElectricity = true;
                                break;
                            }
                        }
                        if (hasElectricity) {
                            int currentBadgesIncreased = entry.getValue().getNumberOfBadges() + 1;
                            entry.getValue().setNumberOfBadges(currentBadgesIncreased);
                            continue;
                        } else {
                            for (Pokemon poke : entry.getValue().getCollectionOfPokemons()) {
                                int currentHealthDecreased = poke.getHealth() - 10;
                                if (currentHealthDecreased <= 0) {
                                    List<Pokemon> localPokemons = new ArrayList<>(entry.getValue().getCollectionOfPokemons());
                                    localPokemons.remove(poke);
                                    entry.getValue().setCollectionOfPokemons(localPokemons);
                                    break;
                                }
                                poke.setHealth(currentHealthDecreased);
                            }
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        List<Trainer> trainerList1 = new ArrayList<>();

        for (Map.Entry<String, Trainer> entry : trainerList.entrySet()) {
            trainerList1.add(entry.getValue());
        }

        trainerList1.sort(Comparator.comparing(Trainer::getNumberOfBadges).reversed());

        for (Trainer trainer : trainerList1) {
            System.out.println(trainer.getName() + " " + trainer.getNumberOfBadges() + " " + trainer.getCollectionOfPokemons().size());
        }
    }
}
