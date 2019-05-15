import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /* Создать класс Student c свойствами name (String), age (double), mark(int). Создать 5 тестовых
         * объектов класса Student и занести их в List. C помощью stream:
         * - получить Set, который содержит имена студентов;
         * - получить Map, где ключ - name, значение - объект Student (1);
         * - получить List студентов, отсортированных по age;
         * - посчитать количество студентов с списке;
         * - посчитать количество уникальных студентов в списке (distinct).
         * Map из пункта (1) с помощью stream:
         * - распечатать содержимое Map в формате ключ=значение, используя форматируемый вывод (String.format);
         * - преобразовать Map в Set, который будет содержать age студентов. */

        List<Student> students = new ArrayList<>();
        Student dasha = new Student("Dasha", 17, 11);

        students.add(new Student("Ann", 18, 10));
        students.add(dasha);
        students.add(new Student("Victor", 19, 10));
        students.add(new Student("Andrey", 18, 8));


        System.out.println("Set, который содержит имена студентов:\n");
        Set<String> setNames = students.stream().map(Student::getName).collect(Collectors.toSet());
        System.out.println(setNames);


        System.out.println("\n\nMap, где ключ - name, значение - объект Student:\n");
        Map<String, Student> map = students.stream().collect(Collectors.toMap(
                name -> name.getName(),
                obj -> obj
        ));
        map.forEach((key, value) -> System.out.println(String.format("Key: %s\nValue: %s\n", key, value.toString())));


        System.out.println("\nSet, который будет содержать age студентов:\n");
        Set<Double> setAges = map.entrySet().stream().map(Map.Entry::getValue).map(Student::getAge).
                collect(Collectors.toSet());
        System.out.println(setAges);


        System.out.println("\nList студентов, отсортированных по age:");
        List<Student> sortedStudents = students.stream().sorted(Comparator.comparingDouble(Student::getAge)).
                collect(Collectors.toList());
        sortedStudents.forEach(student -> System.out.println(student));


        students.add(dasha);
        System.out.println("\nКоличество студентов в списке = " + students.stream().count());
        System.out.println("\nКоличество уникальных студентов в списке = " + students.stream().distinct().count());

    }
}
