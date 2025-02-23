package LLD.Collections.studentSorter.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Student Sorter
Problem Statement
You are given a class Student which stores the data of each student. The Student class has two variables, name and age. Now you are given a list of Student and you need to sort the given list of students according to their age in descending order, i.e. the student with the highest age comes first and the student with the lowest age comes last.

Note: You do not have to create a new list of students, just sort the given list according to age in descending order.


Instructions
Implement the sortStudentsByAgeDescending method inside the StudentSorter class.
Sort the list in descending order of age.
If two or more Students have the same age then keep them in the same order as they appear in the input list.
The code for class Student is already implemented.
Use Comparator to sort the given list.
 */
public class StudentSorter {
        public static void sortStudentsByAgeDescending(List<Student> students) {
        students.sort(Comparator.comparingInt(Student::getAge).reversed());
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 20));
        students.add(new Student("Bob", 25));
        students.add(new Student("Charlie", 22));

        sortStudentsByAgeDescending(students);

        for(Student s:students){
            System.out.println(s.getName()+" "+s.getAge());
        }
    }
}
