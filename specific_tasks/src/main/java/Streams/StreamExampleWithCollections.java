package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleWithCollections {
    public static void main(String[] args) {
        Student st1 = new Student("Ilya", 2, 7.4);
        Student st2 = new Student("Vitalii", 4, 8.5);
        Student st3 = new Student("Tanya", 1, 9.2);
        Student st4 = new Student("Katya", 3, 8.7);
        Student st5 = new Student("Ihor", 2, 6.3);

        List<Student> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);


        // map
        List<Integer> newList1 = list.stream().map(student -> student.getName().length()).collect(Collectors.toList());
        System.out.println(newList1);

        // filter
        List<Student> newList2 = list.stream().filter(student ->
                student.getCourse() > 2 && student.getAvgGrade() > 8.0).toList();
        System.out.println(newList2);


        // foreach
        list.forEach(student ->
                        {int newCourse = student.getCourse() + 1;
                        System.out.println(newCourse);});

        // reduce
        List<Integer> listOfNumbers = List.of(4, 8, 15, 16, 23);

        int result = listOfNumbers.stream().reduce((accumulator, element) ->
                accumulator * element).get();
        System.out.println(result);

        // sorted
        List<Student> newList3 = list.stream().sorted().toList();
        System.out.println(newList3);

/*
         chaining
        int[] arr = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int res = Arrays.stream(arr).filter(e -> (e % 2) != 0)
                .map(e -> {if (e % 3 == 0){e = (e / 3);}return e;})
                .reduce(Integer::sum).getAsInt();
        System.out.println(res);
*/
    }
}
