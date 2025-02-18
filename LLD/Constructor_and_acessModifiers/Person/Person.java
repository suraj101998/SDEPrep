package Person;
/*
 * Create a class Person with following requirements

Should have a data-member age
Should have a data-member name
Should support a constructor with both age and name
 */
public class Person {
    // Data members
    private int age;
    private String name;

    // Constructor with both age and name
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}
