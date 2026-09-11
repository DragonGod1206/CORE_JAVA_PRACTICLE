class Test {
    protected void finalize() {
        System.out.println("Object destroyed");
    }
}

public class Q14GarbageCollectionDemo {
    public static void main(String[] args) {
        Test t = new Test();

        t = null;
        System.gc();
    }
}