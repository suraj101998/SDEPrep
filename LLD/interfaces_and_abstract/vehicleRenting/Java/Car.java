package LLD.interfaces_and_abstract.vehicleRenting.Java;

public class Car implements Rentable {
    public String carModel;
    public boolean isRented;

    public Car(String carModel) {
        this.carModel = carModel;
        this.isRented = false;
    }

    @Override
    public void rent(){
        if (!isRented) {
            isRented = true;
            System.out.println("car is now rented");
        } else {
            System.out.println("car is already rented");
        }
    }

    @Override
    public void returnItem() {
        if (isRented) {
            isRented = false;
            System.out.println("car is now returned");
        } else {
            System.out.println("car was not rented");
        }
    }
}

