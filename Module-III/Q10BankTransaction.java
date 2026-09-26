import java.util.Scanner;

class BankTransaction extends Thread {
    int amount;
    String type;

    BankTransaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public void run() {
        if (type.equals("High-value")) {
            System.out.println("High-value transaction processed first");
        } else {
            System.out.println("Low-value transaction processed later");
        }
    }
}

public class Q10BankTransaction {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Transaction1: Rs");
        int amount1 = sc.nextInt();

        System.out.print("Transaction2: Rs");
        int amount2 = sc.nextInt();

        BankTransaction highValue;
        BankTransaction lowValue;

        if (amount1 > amount2) {
            highValue = new BankTransaction(amount1, "High-value");
            lowValue = new BankTransaction(amount2, "Low-value");
        } else {
            highValue = new BankTransaction(amount2, "High-value");
            lowValue = new BankTransaction(amount1, "Low-value");
        }

        highValue.setPriority(Thread.MAX_PRIORITY);
        lowValue.setPriority(Thread.MIN_PRIORITY);

        highValue.start();
        highValue.join();

        lowValue.start();
        lowValue.join();

        sc.close();
    }
}