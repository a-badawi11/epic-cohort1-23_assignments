/**
 * Create three different methods of getStudentById where:
 * 1.	First one uses Unchecked exception if the user with provided id was not found (RunTimeException)
 * 2.	Second one uses checked exception
 * 3.	Third one uses Optional return type
 */

import java.util.*;

public class Assignment9 {

    static Student2[] students = new Student2[]{
            new Student2(5, "Ahmad"),
            new Student2(3, "Mohammad")
    };

    private static Student2 getStudentById(int id) { // unchecked NoSuchElementException
        return Arrays.stream(students).filter(s -> s.getId() == id).findFirst().get();

    }

    private static Class getClassByName(String className)  { // checked exception

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.out.println("Class with passed name doesn't exists");
            return null;
        }

    }

    private static Optional<Student2> getStudentByIdV3(int id) {

        return Arrays.stream(students).filter(s -> s.getId() == id).findFirst();
    }
}
