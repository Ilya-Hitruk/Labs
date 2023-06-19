package ComparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Joe", "Parker", 10000));
        list.add(new Employee("Bill", "Williams", 12000));
        list.add(new Employee("Sam", "Johnson", 9000));

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        System.out.println(list);
        list.sort(new EmployeeLastNameComparator());
        System.out.println(list);

        System.out.println(list);
        list.sort(new EmployeeSalaryComparator());
        System.out.println(list);
    }
}
