class Base {
    Base() {
        System.out.println("Base Constructor Called");
    }
}

class Derived extends Base {
    Derived() {
        System.out.println("Derived Constructor Called");
    }
}

public class Q9ConstructorDemo {
    public static void main(String[] args) {
        new Derived();
    }
}