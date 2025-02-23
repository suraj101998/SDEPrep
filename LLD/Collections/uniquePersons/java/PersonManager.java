package LLD.Collections.uniquePersons.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonManager {
    public static List<Person> removeDuplicatePersons(List<Person> persons) {
        if(persons == null || persons.isEmpty()){
            return new ArrayList<>();
        }
        List<Person> uniquePersons = new ArrayList<>();
        Set<String> seenNames = new HashSet<>();
        for(Person person : persons){
            if(!seenNames.contains(person.getName())){
                uniquePersons.add(person);
                seenNames.add(person.getName());
            }
        }
        return uniquePersons;
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 20));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Alice", 22));
        persons.add(new Person("Charlie", 22));
        persons.add(new Person("Bob", 30));

        List<Person> result = removeDuplicatePersons(persons);
        for(Person p:result){
            System.out.println(p.getName()+" "+p.getAge());
        }
    }
}