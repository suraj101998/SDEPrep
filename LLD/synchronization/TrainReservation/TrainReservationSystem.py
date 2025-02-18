# Train Reservation System (Assignment)
# Consider an online reservation system for booking tickets for an Indian train system. The system needs to handle concurrent requests from multiple users trying to reserve seats. To ensure thread safety and prevent race conditions, a Reentrant Lock can be employed.

# Requirements:
# The reservation system manages the availability of seats for different seat types on Indian trains, including 1AC, 2AC, 3AC, and Sleeper. You can assume all seats types are available in the train.
# Multiple users can attempt to reserve seats concurrently.
# A user should be able to reserve multiple seats of the same seat type.
# The system should prevent overbooking and ensure the integrity of seat reservations
# ReservationSystem Class
# Instance Variables:
# available_seats: A Map that stores the available seats for each seat type. The key is the seat type and the value is the number of available seats for that particular seat type.
# lock: A Reentrant lock which ensures that only one thread can modify the available seats for any seat type at a time.
# Constructor:
# Initializes the available_seats and lock based on the provided initial available seats.
# reserve_seats Method:
# Takes two parameters: the seat_type and num_seats (the number of seats to reserve).
# Acquires the lock using self.lock to ensure that only one thread can modify the available seats for the seatType at a time.

# Checks if there are enough available seats for the reservation.

# If there are enough seats, it decrements the available seats for the particular seat type and returns True.

# If there are not enough seats, it returns False.

# get_available_seats Method:
# Takes the seat_type as a parameter and returns the number of available seats of that seat type.

import threading
import random

class TrainReservationSystem:
    def __init__(self, initial_seats):
        self.available_seats = initial_seats
        self.lock = threading.RLock()  # Reentrant Lock

    # Method to reserve seats of the desired seat type
    def reserve_seats(self, seat_type, num_seats):
        with self.lock:  # Ensures thread safety while modifying available seats
            if seat_type in self.available_seats and self.available_seats[seat_type] >= num_seats:
                self.available_seats[seat_type] -= num_seats
                return True  # Successfully booked
            else:
                return False  # Not enough seats available

    # Method to get the total number of unreserved seats of the given seat type
    def get_available_seats(self, seat_type):
        with self.lock:  # Ensures thread-safe retrieval
            return self.available_seats.get(seat_type, 0)


# Create initial seat availability dictionary
initial_seats = {
    "1AC": 50,
    "2AC": 100,
    "3AC": 150,
    "Sleeper": 200
}

# Create an instance of TrainReservationSystem
reservation_system = TrainReservationSystem(initial_seats)


# Function to perform concurrent booking
def concurrent_booking(reservation_system, num_threads, seats_per_thread):
    threads = []

    # Create and start multiple threads for concurrent booking
    for _ in range(num_threads):
        seat_type = random.choice(list(reservation_system.available_seats.keys()))
        thread = threading.Thread(target=book_seats, args=(reservation_system, seat_type, seats_per_thread))
        threads.append(thread)
        thread.start()

    # Wait for all threads to complete
    for thread in threads:
        thread.join()


# Function for each thread to attempt booking seats
def book_seats(reservation_system, seat_type, num_seats):
    success = reservation_system.reserve_seats(seat_type, num_seats)
    if success:
        print(f"Successfully booked {num_seats} {seat_type} seats")
    else:
        print(f"Failed to book {num_seats} {seat_type} seats")


num_threads = 10  # Number of concurrent threads
seats_per_thread = 5  # Number of seats each thread attempts to book
concurrent_booking(reservation_system, num_threads, seats_per_thread)

# Check available seats after concurrent bookings
print("Available 1AC seats:", reservation_system.get_available_seats("1AC"))
print("Available 2AC seats:", reservation_system.get_available_seats("2AC"))
print("Available 3AC seats:", reservation_system.get_available_seats("3AC"))
print("Available Sleeper seats:", reservation_system.get_available_seats("Sleeper"))
