import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator extends Thread {
    public void run() {
        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            int number = random.nextInt(10) + 1;

            System.out.println("Generated: " + number);

            if (number % 2 == 0) {
                SquareCalculator square = new SquareCalculator(number);
                square.start();

                try {
                    square.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            } else {
                CubeCalculator cube = new CubeCalculator(number);
                cube.start();

                try {
                    cube.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class SquareCalculator extends Thread {
    int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square: " + (number * number));
    }
}

class CubeCalculator extends Thread {
    int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube: " + (number * number * number));
    }
}

public class Q9IoTSensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        if (choice == 1) {
            RandomNumberGenerator generator =
                new RandomNumberGenerator();

            generator.start();
        } else {
            System.out.println("Exiting...");
        }

        sc.close();
    }
}