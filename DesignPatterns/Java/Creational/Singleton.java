
/*Singleton Pattern
Definition: Ensures that a class has only one instance and provides a global access point to it.
Use Case: Database connection, logging, thread pool, configuration settings.
*/
class Singleton {
    private static Singleton instance;
    private Singleton() { } // Private constructor prevents instantiation
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2);  // true (same instance)
    }
}
// output: true

/*If your singleton implementation is incorrect(e.g., without synchronization in a multi-threaded environment),
multiple instances can be created mistakenly. However, a correctly implemented singleton always holds exactly one instance.*/ 
