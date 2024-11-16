package optionaltesting.findstudent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class FindMyStudent {


    static Optional<Student> findByName(Collection<Student> students, String studentName) {
        return students.stream()
                .filter(student -> student.name()
                .equalsIgnoreCase(studentName))
                .findFirst();
    }

    public static void main(String[] args) {

        Collection<Student> studentCollection = new ArrayList<>(List.of(
                new Student(1, "Dieter"),
                new Student(2, "Berta"),
                new Student(3, "Alpha"),
                new Student(4, "Christina")
        ));

        Optional<Student> foundStudent = findByName(studentCollection, "Dieter");

        foundStudent.ifPresentOrElse(
                student -> System.out.println("Found Student ID " + student.id()),
                () -> System.out.println("ID not found")
        );


    }

}
