class Vehicle {
    void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starting...");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starting...");
    }
}

public class Q8VehicleDemo {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();

        v = new Bike();
        v.start();
    }
}