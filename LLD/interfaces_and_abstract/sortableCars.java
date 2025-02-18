package LLD.interfaces_and_abstract;

/*
 * Write a class Car with following requirements
It should have 2 data-members
Price: int
Speed: int
We should be able to sort a Collection or Array of Cars on price.
Implement required interface for that
 */
class sortableCars implements Comparable<sortableCars> {
    private int Price;
    private int Speed;
    @Override
    public int compareTo(sortableCars other) {
        return this.Price - other.Price;
    }
}
