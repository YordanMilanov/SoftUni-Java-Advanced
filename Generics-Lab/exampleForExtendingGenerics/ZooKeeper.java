package exampleForExtendingGenerics;

import java.util.List;

public class ZooKeeper<T extends Animal> {
    List<T> animals;

    public void sleepAllAnimals() {
        for (T animal : animals) {
            animal.sleep();
        }

        // purpose of the extend(borders) is to be sure that the given by use type later will be correct for the methods
        // and will not lead to any exceptions. By this we are sure that we have the exact methods that we want to use
        // for example now we cannot give Integer on the place of T because the sleep method needs String
    }
}
