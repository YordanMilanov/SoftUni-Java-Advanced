package exampleForExtendingGenerics;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sleep();
        ZooKeeper<Tiger> zooKeeper = new ZooKeeper<>();
        // this is possible because tiger extends animal
        Tiger tiger = new Tiger();
        tiger.sleep();
    }
}
