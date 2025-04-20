package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id =id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary(){
        return salary;
    }
    
}
public class ListEmployeeWithId {
    public static void main(String[] args) {
        List<Employee> empList = Arrays.asList(
                new Employee(1, "Ram", 50000),
                new Employee(2, "Shyam", 80000),
                new Employee(3, "Mohan", 55000)
        );
        // Using streams list of employees with name id salary map it with id and name
        Map<Integer, String> idNameMap = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        System.out.println(idNameMap);

//Now Sort based on id To sort the Map based on id (which is key), you can use LinkedHashMap with Stream.sorted()
        Map<Integer, String> employeeMap = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getId))  // Sort by id
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getName,
                        (e1, e2) -> e1, // In case of duplicate keys
                        LinkedHashMap::new // Maintain insertion order after sorting
                ));

        System.out.println(employeeMap);

        //Return as list
        List<Employee> sortedList = empList.stream()
                .sorted(Comparator.comparingInt(Employee::getId))
                .collect(Collectors.toList());

        sortedList.forEach(e -> System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary()));

    }
}
