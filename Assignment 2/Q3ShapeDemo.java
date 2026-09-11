abstract class Shape {
    abstract void area();
    abstract void perimeter();
}

class Circle extends Shape {
    double r = 5;

    void area() {
        System.out.printf("Circle Area: %.2f%n", Math.PI * r * r);
    }

    void perimeter() {
        System.out.printf("Circle Perimeter: %.2f%n", 2 * Math.PI * r);
    }
}

class Rectangle extends Shape {
    double l = 4, w = 6;

    void area() {
        System.out.println("Rectangle Area: " + l * w);
    }

    void perimeter() {
        System.out.println("Rectangle Perimeter: " + 2 * (l + w));
    }
}

public class Q3ShapeDemo {
    public static void main(String[] args) {
        Shape c = new Circle();
        Shape r = new Rectangle();

        c.area();
        c.perimeter();

        r.area();
        r.perimeter();
    }
}