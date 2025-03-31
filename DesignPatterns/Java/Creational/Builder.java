
/*
 * Builder Pattern
Definition: Separates the construction of a complex object from its representation.
Use Case: When an object has multiple optional parameters 
(e.g., Burger with cheese, no lettuce, extra sauce).
 */
class Burger {
    private boolean cheese;
    private boolean lettuce;

    private Burger(BurgerBuilder builder) {
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
    }

    @Override
    public String toString() {
        return "Burger { Cheese: " + cheese + ", Lettuce: " + lettuce + " }";
    }

    static class BurgerBuilder {
        private boolean cheese;
        private boolean lettuce;

        public BurgerBuilder addCheese() {
            this.cheese = true;
            return this;
        }

        public BurgerBuilder addLettuce() {
            this.lettuce = true;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }

    public static void main(String[] args) {
        Burger burger = new Burger.BurgerBuilder().addCheese().addLettuce().build();
        System.out.println("ans: " + burger);
    }
}
// ans: Burger { Cheese: true, Lettuce: true }

