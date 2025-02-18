package LLD;
/*
 * Design A cache management system. 
 * Define requirement and Constraints of the service. 
 * Choose appropriate data storage and retrival mechanisms. 
 * construct how the DB and cache Schema will be and how you will write into the DB and Fetch from the DB.
 */

/*
 * 1. Requirements

 Functional Requirements:
Read Efficiency: Frequently accessed data should be served quickly.
Write Consistency: Updates to data should be reflected in both the cache and database.
Eviction Policies: Support Least Recently Used (LRU), First In First Out (FIFO), or Time-to-Live (TTL) policies.
Scalability: Handle a growing volume of requests efficiently.
Fault Tolerance: Ensure system reliability if the cache fails.

Non-Functional Requirements:
Low Latency: Provide sub-millisecond responses for cached data.
High Availability: Ensure 99.9% uptime for the cache system.
Durability: Cache should not lose data during service restarts.

2. Constraints
Cache size is limited (e.g., 1 GB or 10,000 items).
Cached data should be consistent with the database.
Write operations should prioritize durability over speed.
Read requests are expected to be much higher than writes (80-20 read-write split).

3. Choosing Data Storage and Retrieval Mechanisms

Cache Layer:
Technology: Use an in-memory caching system like Redis or Memcached.
Storage: Key-value pairs (e.g., key = item_id, value = item_details).
Eviction Policy: Use LRU or TTL for eviction to manage space.

Database Layer:
Technology: Use a relational database like PostgreSQL or NoSQL database like MongoDB.
Schema: Store structured data in tables or collections for persistent storage.

4. Database Schema Design
Example Use Case: Caching Product Details
Product Table (Relational Database Schema):

Field	Type	Description
product_id	INT	Primary Key
name	VARCHAR	Name of the product
description	TEXT	Product description
price	DECIMAL	Price of the product
last_updated	TIMESTAMP	Last modification timestamp

5. Cache Schema
Cache Structure (Key-Value Pair):
Key: product:<product_id>
Value: Serialized JSON object with product details
Example:
{
  "product_id": 1,
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.00,
  "last_updated": "2025-01-28T14:30:00"
}

6. System Design
Workflow for Read Operation:

Check Cache:
Search for the requested data in the cache using the product ID as the key.
If found, return the cached value (Cache Hit).
If not found (Cache Miss), fetch data from the database.

Fetch from Database:
Query the database for the required data.
Populate the cache with the retrieved data to serve future requests.


Workflow for Write Operation:

Update Database:
Write the data into the database.

Update Cache:
If the data is in the cache, update or invalidate the cached entry.
Optionally, prefetch related items into the cache.

Cache Eviction Policies:
LRU: Remove the least recently used data when the cache is full.
TTL: Remove data after a predefined time-to-live.
 */
import redis.clients.jedis.Jedis;

public class cacheManagementSystem {
    private Jedis cache = new Jedis("localhost"); // Connect to Redis

    public void writeDataToDBAndCache(int productId, String name, String description, double price) {
        String sql = "INSERT INTO product (product_id, name, description, price, last_updated) " +
                     "VALUES (?, ?, ?, ?, NOW()) ON DUPLICATE KEY UPDATE " +
                     "name = ?, description = ?, price = ?, last_updated = NOW()";

        // Write to Cache
        String key = "product:" + productId;
        String value = String.format("{\"product_id\":%d,\"name\":\"%s\",\"description\":\"%s\",\"price\":%.2f}",
                                      productId, name, description, price);
        cache.set(key, value);
    }

    public String readData(int productId) {
        String key = "product:" + productId;

        // Check Cache
        String cachedData = cache.get(key);
        if (cachedData != null) {
            return cachedData; // Cache Hit
        }

        // Cache Miss: Fetch from DB
        String sql = "SELECT * FROM product WHERE product_id = ?";
        // Execute query and fetch result into `product`

        // Populate Cache
        cache.set(key, product);
        return product;
    }
}

/*Diagram:
 Client --> Cache (Redis) --> [Cache Hit --> Return Data]
                       \--> [Cache Miss --> DB (PostgreSQL)] --> Cache

9. Performance Optimization
Use batch writes to reduce frequent DB writes.
Use async updates to improve latency for write-heavy systems.
Partition data in the database and cache for scalability.

10. Monitoring
Monitor cache hit/miss ratio to evaluate effectiveness.
Use tools like Redis Insight for cache metrics.
Implement logging for fallback operations to the database.
 */