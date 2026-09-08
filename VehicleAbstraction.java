abstract class Vehicle {
    protected String vehicleNumber;
    protected String brand;

    Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }
    abstract void startEngine();

    final void showVehicleIdentity() {
        System.out.println("Vehicle Number = " + vehicleNumber);
        System.out.println("Brand = " + brand);
    }
}

class Car extends Vehicle {

    Car(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    @Override
    void startEngine() {
        System.out.println("Car engine starts with a key/button.");
    }
}

class Bike extends Vehicle {

    Bike(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }
    @Override
    void startEngine() {
        System.out.println("Bike engine starts using a self-start/kick.");
    }
}

public class VehicleAbstraction {

    public static void main(String[] args) {

        Car car = new Car("KA01AB1234", "Toyota");

        System.out.println("----- Car Details -----");
        car.showVehicleIdentity();
        car.startEngine();
        System.out.println();
        Bike bike = new Bike("KA05XY5678", "Honda");
        System.out.println("----- Bike Details -----");
        bike.showVehicleIdentity();
        bike.startEngine();
        System.out.println();
        Car car2 = new Car("KA09CD9876", "Hyundai");
        System.out.println("----- Constructor Verification -----");
        car2.showVehicleIdentity();
        car2.startEngine();
    }
}