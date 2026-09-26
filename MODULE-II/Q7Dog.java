class Animal {
    void type() {
        System.out.println("Animal Type: Mammal");
    }
}

class Mammal extends Animal {
}

class Dog extends Mammal {
    String name, breed;

    Dog(String n, String b) {
        name = n;
        breed = b;
    }

    void display() {
        System.out.println("Dog Name: " + name);
        System.out.println("Breed: " + breed);
        type();
    }
}

public class Q7Dog {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "Labrador");
        d.display();
    }
}