final class A {
}

class B {
    final int x = 100;

    final void show() {
        System.out.println("Final method cannot be overridden");
    }
}

public class Q11FinalDemo {
    public static void main(String[] args) {
        B b = new B();

        System.out.println("Final variable: " + b.x);
        System.out.println("Final class cannot be inherited");
        b.show();
    }
}
