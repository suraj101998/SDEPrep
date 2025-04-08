package DesignPatterns.Java.Structural;
/*
 * Proxy Pattern
Definition: Provides a surrogate or placeholder to control access to an object.
Use Case: Lazy initialization, logging, security, or restricting access.
 */
import java.util.List;
interface Internet {
    void connectTo(String site);
}

class RealInternet implements Internet {
    public void connectTo(String site) { System.out.println("Connecting to " + site); }
}

class ProxyInternet implements Internet {
    private RealInternet realInternet = new RealInternet();
    private static List<String> bannedSites = List.of("blocked.com");

    public void connectTo(String site) {
        if (bannedSites.contains(site)) {
            System.out.println("Access Denied to " + site);
        } else {
            realInternet.connectTo(site);
        }
    }
}

public class Proxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connectTo("google.com");
        internet.connectTo("blocked.com");
    }
}
