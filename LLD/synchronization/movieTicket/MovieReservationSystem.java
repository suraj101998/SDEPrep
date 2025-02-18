package LLD.synchronization.movieTicket;
/*
 * Movie Ticket Booking (Assignment)
Consider an online reservation system for booking tickets for a movie hall. The system needs to handle concurrent requests from multiple users trying to reserve seats. To ensure thread safety and prevent race conditions, a Reentrant Lock can be employed. You can assume there is only one movie for which people are trying to book tickets.

Requirements:
The reservation system manages the availability of seats for a movie hall.
Multiple users can attempt to reserve seats concurrently.
A user should be able to reserve multiple seats in one booking.
The system should prevent overbooking and ensure the integrity of seat reservations.
MovieReservationSystem Class
Instance Variables:
availableSeats: An integer representing the total number of available seats for the movie.
reservationLock: A ReentrantLock used to ensure thread safety when modifying the availableSeats.
Constructor:
Initializes the availableSeats with the total number of seats provided as an argument.
Creates a ReentrantLock instance to be used for synchronization.
reserveSeats Method:
Takes an integer numSeats as a parameter representing the number of seats a user wants to reserve.
Acquires the reservationLock using lock() to ensure that only one thread can modify the availableSeats at a time.
Checks if there are enough available seats:
If there are enough seats, it decrements the availableSeats by numSeats and returns true.
If there are not enough seats, it returns false.
Releases the lock using unlock() before returning (in the finally block).
getAvailableSeats Method:
Returns the current number of available seats for the movie.
Summary
This simplified implementation manages the reservation of seats for a single movie, with the total number of available seats represented as an integer.
Thread safety is ensured using a ReentrantLock, allowing multiple users to reserve seats concurrently while preventing race conditions.
The reserveSeats method allows users to reserve seats, and the getAvailableSeats method provides information about the remaining available seats.
 */

 import java.util.concurrent.locks.Lock;
 import java.util.concurrent.locks.ReentrantLock;
 
 public class MovieReservationSystem {
     private int availableSeats;
     private final Lock reservationLock;
 
     public MovieReservationSystem(int totalSeats) {
         this.availableSeats = totalSeats; // Correct initialization
         this.reservationLock = new ReentrantLock();
     }
 
     public boolean reserveSeats(int numSeats) {
         reservationLock.lock(); // Acquire the lock before modifying availableSeats
         try {
             if (numSeats <= availableSeats) {
                 availableSeats -= numSeats;
                 return true; // Successful reservation
             }
             return false; // Not enough seats available
         } finally {
             reservationLock.unlock(); // Correctly releasing the lock
         }
     }
 
     public int getAvailableSeats() {
         return availableSeats;
     }
 }
 
