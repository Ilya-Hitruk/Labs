package ComparableAndComparator;

import org.jetbrains.annotations.NotNull;

public record Employee(String firstName, String lastName, int salary) implements Comparable<Employee> {

    @Override
    public int compareTo(@NotNull Employee anotherEmployee) {
        return this.firstName().compareTo(anotherEmployee.firstName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
