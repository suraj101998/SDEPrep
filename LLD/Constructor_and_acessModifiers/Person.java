/*
 * Create a class Person with following requirements

Should have a data-member age
Should have a data-member name
Should support a constructor with both age and name
 */

 public class Person {
    private int age;
    private String name;
    public Person(int age,String name){
        this.age = age;
        this.name= name;
    }
    // Getter methods
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person person = new Person(25, "Alice");
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}