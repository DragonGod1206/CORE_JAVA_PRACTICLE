import java.util.Scanner;

class ArrayDivision {
    int[] arr = {10, 20, 30, 40};

    void divide(int index, int divisor) {
        try {
            int result = arr[index] / divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero not allowed");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Array index out of bounds");
        }
    }
}

public class Q3ArrayDivision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        ArrayDivision obj = new ArrayDivision();
        obj.divide(index, divisor);

        sc.close();
    }
}