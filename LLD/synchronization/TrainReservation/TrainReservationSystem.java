package LLD.synchronization.TrainReservation;
/*
 * Train Reservation System (Assignment)
Consider an online reservation system for booking tickets for an Indian train system. The system needs to handle concurrent requests from multiple users trying to reserve seats. To ensure thread safety and prevent race conditions, a Reentrant Lock can be employed.

Requirements:
The reservation system manages the availability of seats for different seat types on Indian trains, including 1AC, 2AC, 3AC, and Sleeper. You can assume all seats types are available in the train.
Multiple users can attempt to reserve seats concurrently.
A user should be able to reserve multiple seats of the same seat type.
The system should prevent overbooking and ensure the integrity of seat reservations
ReservationSystem Class
Instance Variables:
availableSeats: A Map that stores the available seats for each seat type. The key is the seat type and the value is the number of available seats for that particular seat type.
seatTypeLocks: Another Map that stores locks associated with each seat type. This map ensures that only one thread can modify the available seats for a particular seat type at a time.
Constructor:
Initializes the availableSeats and seatTypeLocks maps based on the provided initial available seats.
reserveSeats Method:
Takes two parameters: the seat type and the number of seats to reserve.
Retrieves the lock associated with the specified seatType from the eventLocks map.
Acquires the lock using lock() to ensure that only one thread can modify the available seats for the seatType at a time.

Checks if there are enough available seats for the reservation.

If there are enough seats, it decrements the available seats for the particular seat type and returns true.

If there are not enough seats, it returns false.

Releases the lock using unlock() before returning.

getAvailableSeats Method:
Takes the seatType name as a parameter and returns the number of available seats of that seat type.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrainReservationSystem {
    private final Map<String, Integer> availableSeats;
    private final Map<String, Lock> seatTypeLocks;

    public TrainReservationSystem(Map<String, Integer> availableSeats) {
        this.availableSeats = new HashMap<>(availableSeats);
        this.seatTypeLocks = new HashMap<>();
        for (String seatType : availableSeats.keySet()) {
            seatTypeLocks.put(seatType, new ReentrantLock());
        }
    }

    public boolean reserveSeats(String seatType, int numSeats) {
        Lock lock = seatTypeLocks.get(seatType);
        if (lock == null) {
            return false; // Invalid seat type
        }

        lock.lock(); // Acquire the lock before modifying the seat count
        try {
            int currentSeats = availableSeats.getOrDefault(seatType, 0);
            if (numSeats <= currentSeats) {
                availableSeats.put(seatType, currentSeats - numSeats);
                return true; // Successfully reserved seats
            }
            return false; // Not enough seats available
        } finally {
            lock.unlock(); // Release the lock in finally block to ensure it's always executed
        }
    }

    public int getAvailableSeats(String seatType) {
        return availableSeats.getOrDefault(seatType, 0);
    }
}

