package CodingInterview;

/*Service Request Assignment System

A company provides on-site services in different cities. Customers raise service requests, 
and each request needs to be assigned to a salesperson in the same city. 
The company follows these rules for assignment:

Rules for Assignment:

Each service request has an ID, priority (High, Medium, Low), location, 
and status (Pending, Assigned, or Completed).
Each salesperson has an ID, location, and a maximum number of requests (capacity) 
they can handle at a time.
Requests should be assigned to a salesperson in the same city.
A salesperson cannot exceed their capacity.

Requests should be assigned in priority order:

High priority requests should be assigned first.
If two requests have the same priority, their original order in the list should be maintained.
Once assigned, the request's status should be updated to "Assigned".
If no salesperson is available in the city, the request remains "Pending".

Task:
Write a Java program to assign service requests to salespersons based on the above rules and 
print the final assignments.
 */
import java.util.*;

// Represents a Service Request
class ServiceRequest {
    int id;
    String priority; // High, Medium, Low
    String location;
    String status; // Pending, Assigned, Completed

    public ServiceRequest(int id, String priority, String location, String status) {
        this.id = id;
        this.priority = priority;
        this.location = location;
        this.status = status;
    }
}

// Represents a Salesperson
class Salesperson {
    int id;
    String location;
    int capacity; // Maximum requests they can handle at a time
    List<ServiceRequest> assignedRequests;

    public Salesperson(int id, String location, int capacity) {
        this.id = id;
        this.location = location;
        this.capacity = capacity;
        this.assignedRequests = new ArrayList<>();
    }

    public boolean canTakeMoreRequests() {
        return assignedRequests.size() < capacity;
    }
}

// ServiceManager to assign requests
class ServiceManager {
    List<Salesperson> salespersons;
    List<ServiceRequest> requests;

    public ServiceManager(List<Salesperson> salespersons, List<ServiceRequest> requests) {
        this.salespersons = salespersons;
        this.requests = requests;
    }

    // TASK: Assign requests based on the given rules
    public void assignRequests() {
        // Sort requests by priority (High > Medium > Low)
        requests.sort((r1, r2) -> {
            if (r1.priority.equals(r2.priority)) return 0;
            if (r1.priority.equals("High")) return -1;
            if (r1.priority.equals("Medium") && r2.priority.equals("Low")) return -1;
            return 1;
        });

        for (ServiceRequest request : requests) {
            if (!request.status.equals("Pending")) continue; // Skip non-pending requests

            for (Salesperson salesperson : salespersons) {
                if (salesperson.location.equals(request.location) && salesperson.canTakeMoreRequests()) {
                    // Assign the request
                    salesperson.assignedRequests.add(request);
                    request.status = "Assigned";
                    break;
                }
            }
        }
    }

    // Print the assignments
    public void printAssignments() {
        for (Salesperson salesperson : salespersons) {
            System.out.println("Salesperson ID: " + salesperson.id);
            for (ServiceRequest request : salesperson.assignedRequests) {
                System.out.println("    Assigned Request ID: " + request.id + ", Priority: " + request.priority + ", Location: " + request.location);
            }
        }
    }
}

public class handleServiceRequest {
    public static void main(String[] args) {
        // Create salespersons
        List<Salesperson> salespersons = Arrays.asList(
            new Salesperson(1, "CityA", 2),
            new Salesperson(2, "CityB", 3)
        );

        // Create service requests
        List<ServiceRequest> requests = Arrays.asList(
            new ServiceRequest(101, "High", "CityA", "Pending"),
            new ServiceRequest(102, "Low", "CityA", "Pending"),
            new ServiceRequest(103, "Low", "CityB", "Pending"),
            new ServiceRequest(104, "High", "CityB", "Pending"),
            new ServiceRequest(105, "Medium", "CityB", "Pending"),
            new ServiceRequest(106, "Medium", "CityC", "Pending"),
            new ServiceRequest(107, "Low", "CityB", "Pending"),
            new ServiceRequest(108, "Medium", "CityA", "Pending")
        );

        // Create ServiceManager and assign requests
        ServiceManager manager = new ServiceManager(salespersons, requests);
        manager.assignRequests();

        // Print assignments
        manager.printAssignments();
    }
}

/*
 * Explanation of the Code:
Classes Design:

ServiceRequest Class:
Represents each service request with attributes like id, priority, location, and status.

Salesperson Class:
Represents a salesperson with attributes like id, location, capacity, and the list of assignedRequests.

ServiceManager Class:
Manages the logic for assigning requests:
Requests are sorted by priority (High > Medium > Low) using a custom comparator.
For each pending request:
Assign it to the first available salesperson in the same location with remaining capacity.
Includes the printAssignments method to display the current state of assignments.

Main Method:
Initializes a list of salespersons and service requests.
Uses the ServiceManager to assign requests and print the results.


Time Complexity:
Sorting Requests: O(N log N), where N is the number of service requests.
Assigning Requests: O(N * M), where M is the number of salespersons.
For each request, we check all salespersons to find a match.
Overall Time Complexity: O(N log N + N * M)

Space Complexity:
Sorting the requests uses O(N) for the sorted array.
Additional memory usage depends on the list of requests and assignments.
Overall Space Complexity: O(N)
 */