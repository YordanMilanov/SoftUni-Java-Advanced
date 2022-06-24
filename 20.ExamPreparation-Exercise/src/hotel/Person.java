package hotel;

public class Person {
    String name;
    int id;
    int age;
    String hometown = "n/a";

    public Person(String name, int id, int age, String homeTown) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hometown = homeTown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String homeTown) {
        this.hometown = homeTown;
    }

    @Override
    public String toString() {
        return String.format("Person %s: %d, Age: %d, Hometown: %s",this.name, this.id, this.age, this.hometown);
    }
}
