class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Q4Calculator {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println(c.add(3, 4));
        System.out.println(c.add(2.5, 3.2));
        System.out.println(c.add(4, 5, 6));
    }
}