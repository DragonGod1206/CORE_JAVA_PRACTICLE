class ObjectCount {
    static int count = 0;

    ObjectCount() {
        count++;
    }
}

public class Q12StaticDemo {
    public static void main(String[] args) {
        new ObjectCount();
        new ObjectCount();
        new ObjectCount();

        System.out.println("Number of objects: "
                           + ObjectCount.count);
    }
}