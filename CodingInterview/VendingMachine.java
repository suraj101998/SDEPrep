package CodingInterview;

/*
 * Problem Breakdown
The VendingMachine stores drinks identified by a buttonNumber.

Each drink has:

Stock (quantity available)
Price per unit
Users can request a drink by pressing a button and inserting money.

The vending machine must:
Serve the drink if stock > 0 and money >= price.

Return the correct change.
Throw appropriate exceptions for out-of-stock or insufficient money cases.
We must handle up to 10⁴ requests efficiently.
 */

/*
 * Approach
1. Data Structures
HashMap (buttonToDrink) → Maps buttonNumber to drink.
HashMap (stock) → Stores the stock of each drink.
HashMap (price) → Stores the price of each drink.

2. Algorithm
Register Drinks (registerDrink) → Store drinks in a HashMap.
Process Requests (dispatch)
Check if drink is registered.
Check stock availability.
Check if money is sufficient.
Deduct stock, compute change, and return result.

3. Time Complexity
Registration (registerDrink) → O(1) per drink.
Processing Requests (dispatch) → O(1) per request.
Overall Complexity → O(N) N requests.
 */
import java.util.HashMap;
import java.util.Map;

class Drink {
    private int price;
    private String name;
    private int quantity;

    public Drink(int price, String name, int quantity) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InsufficientMoneyException extends Exception {
    public InsufficientMoneyException(String message) {
        super(message);
    }
}

class ServeDrinkSummary {
    Drink servedDrink;
    int change;

    public ServeDrinkSummary(Drink drink, int change) {
        this.servedDrink = drink;
        this.change = change;
    }

    @Override
    public String toString() {
        return "Drink Served: " + (servedDrink != null ? servedDrink.getName() : "None") + ", Change: " + change;
    }
}

class VendingMachines {
    private Map<Integer, Drink> buttonToDrink = new HashMap<>();
    private Map<Drink, Integer> stock = new HashMap<>();

    public void registerDrink(int button, Drink drink) {
        buttonToDrink.put(button, drink);
        stock.put(drink, drink.getQuantity());
    }

    public ServeDrinkSummary dispatch(int buttonPressed, int money) 
            throws OutOfStockException, InsufficientMoneyException {
        Drink drink = buttonToDrink.get(buttonPressed);

        if (drink == null) {
            throw new IllegalArgumentException("Invalid button number: " + buttonPressed);
        }

        int availableStock = stock.getOrDefault(drink, 0);
        int drinkPrice = drink.getPrice();

        if (availableStock == 0) {
            throw new OutOfStockException(drink.getName() + " is out of stock");
        }

        if (money < drinkPrice) {
            throw new InsufficientMoneyException("Insufficient money");
        }

        stock.put(drink, availableStock - 1);
        drink.decreaseQuantity();

        return new ServeDrinkSummary(drink, money - drinkPrice);
    }
}

public class VendingMachine {
    public static void main(String[] args) {
        VendingMachines vendingMachine = new VendingMachines();

        Drink coke = new Drink(25, "Coke", 5);
        Drink fanta = new Drink(30, "Fanta", 3);
        Drink sprite = new Drink(20, "Sprite", 0);

        vendingMachine.registerDrink(1, coke);
        vendingMachine.registerDrink(2, fanta);
        vendingMachine.registerDrink(3, sprite);

        try {
            ServeDrinkSummary summary = vendingMachine.dispatch(1, 50);
            System.out.println(summary);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}