class Parent {
    int value = 50;

    Parent() {
        System.out.println("Parent constructor called");
    }

    void show() {
        System.out.println("Parent method called");
    }
}

class Child extends Parent {
    Child() {
        super();
    }

    void display() {
        super.show();
        System.out.println("Parent value: " + super.value);
    }
}

public class Q13SuperDemo {
    public static void main(String[] args) {
        Child c = new Child();
        c.display();
    }
}