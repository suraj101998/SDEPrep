package LLD.interfaces_and_abstract.vehicleRenting.Java;

public class Bicycle implements Rentable {
    public String bicycleModel;
    public boolean isRented;

    public Bicycle(String bicycleModel) {
        this.bicycleModel = bicycleModel;
        this.isRented = false;
    }

    @Override
    public void rent() {
        if (!isRented) {
            isRented = true;
            System.out.println("cycle is now rented");
        } else {
            System.out.println("cycle is already rented");
        }
    }

    @Override
    public void returnItem() {
        if (isRented) {
            isRented = false;
            System.out.println("cycle is now returned");
        } else {
            System.out.println("cycle was not rented");
        }
    }
}

