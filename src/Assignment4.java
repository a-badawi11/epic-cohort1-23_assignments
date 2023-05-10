/*
Assignment #4:
Use Stream class to do the following:
1.	Use Stream of Students to return List of Student’s Age
2.	Use Stream of Students to group them by two age categories (< 20 , >=20)
Use our implementation of reduce to:
1.	collect array of T into List<T>
2.	group array of T using keyExtractor function, and valueExtractor function (output will be Map<Key,List<Value>>
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static java.util.stream.Collectors.groupingBy;

public class Assignment4 {
    static Student[] students = new Student[]{
            Student.of("Ahmad", 20, Gender.MALE, true, Course.MATH, Course.CHEMISTRY, Course.JAVA),
            Student.of("Mohammad", 25, Gender.MALE, true, Course.MATH, Course.JAVA),
            Student.of("ESA", 27, Gender.MALE, false, Course.MATH, Course.JAVA),
            Student.of("ESRA", 19, Gender.FEMALE, true, Course.MATH, Course.ENGLISH),
            Student.of("DANA", 40, Gender.FEMALE, true, Course.MATH, Course.ENGLISH, Course.PHYSICS),
            Student.of("RUBA", 22, Gender.FEMALE, true, Course.MATH, Course.PHYSICS)

    };

    public static void main(String[] args) {
        System.out.println("List of student ages: " + getStudentAges().toString());

        Map<String, List<Student>> map = groupByAge();

        System.out.println("students with age equal or greater than 20");
        map.get(">=20").forEach(s -> System.out.println(s.getName()));

        System.out.println("students with age less than 20");
        map.get("<20").forEach(s -> System.out.println(s.getName()));

    }

    private static List<Integer> getStudentAges() {
        return Stream.of(students).map(Student::getAge).collect(Collectors.toList());
    }


    private static Map<String, List<Student>> groupByAge() {
        return Stream.of(students).collect(groupingBy(s -> s.getAge() >= 20 ? ">=20":"<20"));
    }


    public static <T> List<T> toList(T...data){

        return reduceL(new ArrayList<>(),
                acc -> e -> {
                    acc.add(e);
                    return acc;
                }, data);
    }

    public static <U,T> U reduceL(U seed, Function<U, Function<T,U>> accFunction, T... data){

        if(data == null || data.length==0){
            return seed;
        }
        U accResult = seed;

        for (int i = 0; i < data.length; i++) {
            accResult=accFunction.apply(accResult).apply(data[i]);
        }

        return accResult;
    }

}
