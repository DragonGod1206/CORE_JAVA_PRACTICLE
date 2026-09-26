interface Shape {
    default void show(String name) {
        System.out.println("Shape: " + name);
    }

    static void message() {
        System.out.println("Static method from interface");
    }
}

public class Q17InterfaceMethodsDemo {
    public static void main(String[] args) {
        Shape s = new Shape() {};

        s.show("Square");
        s.show("Triangle");

        Shape.message();
    }
}