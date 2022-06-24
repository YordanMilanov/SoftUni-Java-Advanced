package university;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class University {
    public static List<Student> students = null;
    public static int capacity;

    public University(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public static String registerStudent(Student student) {
        boolean isInUniversity = false;
        for (Student studentToCompare : students) {
            if (studentToCompare.getFirstName().equals(student.getFirstName()) && studentToCompare.getLastName().equals(student.getLastName())) {
                isInUniversity = true;
                break;
            }
        }
        if (isInUniversity) {
            return "Student is already in the university";
        } else {
            if (students.size() < capacity) {
                students.add(student);
                return "Added student " + student.getFirstName() + " " + student.getLastName();
            } else {
                return "No seats in the university";
            }
        }
    }

    public static String dismissStudent(Student student) {
        if (students.contains(student)) {
            String toReturn = "Removed student " + student.getFirstName() + " " + student.getLastName();
            students.remove(student);
            return toReturn;
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        Student studentToReturn = null;
        if (!students.isEmpty()) {
            for (Student student : students) {
                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                    studentToReturn = student;
                }
            }
        }
        return studentToReturn;
    }

    public static String getStatistics() {
        return students.stream().map(s -> String.format(
                        "==Student: First Name = %s, Last Name = %s, Best Subject = %s"
                        , s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
