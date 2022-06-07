package CompanyRoaster_02;

public class Employee {
    //mandatory
    private String name;


    private double salary;
    private String department;
    private String position;
    //optional
    private String email;
    private int age;

    public Employee(String name, double salary, String department, String position) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, double salary, String department, String position, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String department, String position, String email) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.email = email;
    }

    public Employee(String name, double salary, String department, String position, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name + " ").append(String.format("%.2f ", salary));
        if (email != null) {
            builder.append(email + " ");
        } else {
            builder.append("n/a" + " ");
        }

        if (age == 0) {
            builder.append("-1");
        } else {
            builder.append(age);
        }

        return builder.toString();
    }
}
