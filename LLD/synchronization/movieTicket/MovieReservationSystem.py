# Movie Ticket Booking
# Consider an online reservation system for booking tickets for a movie hall. The system needs to handle concurrent requests from multiple users trying to reserve seats. To ensure thread safety and prevent race conditions, a Reentrant Lock can be employed. You can assume there is only one movie for which people are trying to book tickets.

# Requirements:
# The reservation system manages the availability of seats for a movie hall.
# Multiple users can attempt to reserve seats concurrently.
# A user should be able to reserve multiple seats in one booking.
# The system should prevent overbooking and ensure the integrity of seat reservations.
# MovieTicketBookingSystem Class
# Instance Variables:
# available_seats: An integer representing the total number of available seats for the movie.
# lock: A ReentrantLock used to ensure thread safety when modifying the availableSeats.
# total_seats: An integer denoting the total number of seats available for reservation.
# Constructor:
# Initializes the available_seats and total_seats with the total number of seats provided as an argument.
# Creates a ReentrantLock instance to be used for synchronization.
# reserve_seats Method:
# Takes an integer num_seats as a parameter representing the number of seats a user wants to reserve.
# Acquires the reservationLock using self.lock to ensure that only one thread can modify the availableSeats at a time.
# Checks if there are enough available seats:
# If there are enough seats, it decrements the availableSeats by num_seats and returns True.
# If there are not enough seats, it returns False.
# get_available_seats Method:
# Returns the current number of available seats for the movie.
# Summary
# This simplified implementation manages the reservation of seats for a single movie, with the total number of available seats represented as an integer.
# Thread safety is ensured using a ReentrantLock, allowing multiple users to reserve seats concurrently while preventing race conditions.
# The reserve_seats method allows users to reserve seats, and the get_available_seats method provides information about the remaining available seats.

import threading

class MovieTicketBookingSystem:
    # Initializes lock, total seats, and available seats for reservation
    def __init__(self, total_seats):
        self.total_seats = total_seats
        self.available_seats = total_seats
        self.lock = threading.Lock()

    def reserve_seats(self, num_seats):
        # Acquire the lock before modifying available seats
        with self.lock:
            if num_seats <= self.available_seats:
                self.available_seats -= num_seats
                return True  # Successfully booked
            else:
                return False  # Not enough seats available

    def get_available_seats(self):
        # Ensures thread-safe retrieval of available seats
        with self.lock:
            return self.available_seats


def book_seats(booking_system, num_seats):
    success = booking_system.reserve_seats(num_seats)
    if success:
        print(f"Successfully booked {num_seats} seats")
    else:
        print(f"Failed to book {num_seats} seats")