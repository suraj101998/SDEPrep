package SystemDesign;
/*
 * Design a URL shortening Service. Define requirement and Constraints of the service. 
 * Choose appropriate data storage and retrival mechanisms. 
 * Implement a system to generate unique short URL for long URL and redirect usres from short to long URL
 */

/*
 * 1. Requirements
 * 
Functional Requirements:
Generate a unique short URL for a given long URL.
Redirect users from the short URL to the corresponding long URL.
Avoid collisions (two different long URLs should not produce the same short URL).
Track the number of times a short URL is accessed (optional).
Support custom aliases for short URLs (optional).

Non-functional Requirements:
The service should be highly available and reliable.
The short URLs should be quick to generate and resolve.
The system should be scalable to handle a large number of users.

2. Constraints
Short URLs must be compact (e.g., 6-8 characters long).
The short URL should be valid for a long time (or forever).
Handle high throughput: e.g., thousands of requests per second.

3. Data Storage and Retrieval
Data Model:
The core table will map short URLs to long URLs:

Table Name: URLMapping
id (primary key): Auto-increment integer.
short_url: The unique short URL.
long_url: The corresponding long URL.
created_at: Timestamp when the mapping was created.
access_count: (Optional) Track usage stats.

Database Options:
Relational Database (e.g., MySQL, PostgreSQL): Ideal for simplicity and structured queries.
NoSQL Database (e.g., MongoDB, Redis): Suitable for high scalability and fast lookups.

4. System Design
Components:
API Server:
Accepts requests to shorten URLs or resolve short URLs.
Handles business logic for generating unique short URLs.

Database:
Stores URL mappings.
Ensures unique mappings between short and long URLs.

Hashing Algorithm:
Generates unique short URLs.
Options include Base62 encoding or hashing with collision handling.
Cache (optional):
Use Redis to cache frequently accessed short URLs for faster resolution.

5. Implementation
Generate Short URLs:
Use a Base62 encoding (characters a-z, A-Z, 0-9) to encode the unique database id into a short URL.
 */
import java.util.concurrent.ConcurrentHashMap;

public class URLShroteningService {
    private static final String BASE62_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = 62;
    private static final ConcurrentHashMap<String, String> urlMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> reverseMap = new ConcurrentHashMap<>();
    private static int idCounter = 1;

    // Generate a unique short URL
    public static String shortenURL(String longURL) {
        if (reverseMap.containsKey(longURL)) {
            return reverseMap.get(longURL); // Return existing short URL if already exists
        }

        String shortURL = encodeBase62(idCounter);
        urlMap.put(shortURL, longURL);
        reverseMap.put(longURL, shortURL);
        idCounter++;
        return "https://bit.ly/" + shortURL;
    }

    // Retrieve the long URL from a short URL
    public static String resolveURL(String shortURL) {
        String key = shortURL.replace("https://bit.ly/", "");
        return urlMap.getOrDefault(key, "URL not found");
    }

    // Base62 encoding for unique short URLs
    private static String encodeBase62(int id) {
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(BASE62_CHARS.charAt(id % BASE));
            id /= BASE;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        // Example Usage
        String longURL1 = "https://www.google.com/articles/2014/december/python-basics";
        String shortURL1 = shortenURL(longURL1);
        System.out.println("Short URL for " + longURL1 + ": " + shortURL1);
        System.out.println("Long URL for " + shortURL1 + ": " + resolveURL(shortURL1));
    }
}

