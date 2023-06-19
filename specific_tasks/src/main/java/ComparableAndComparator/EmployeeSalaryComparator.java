package ComparableAndComparator;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        Integer s1 = o1.getSalary();
        Integer s2 = o2.getSalary();
        return s1.compareTo(s2);
    }
}
