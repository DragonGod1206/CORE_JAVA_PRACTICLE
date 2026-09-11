class BankAccount {
    private int accountNumber;
    private double balance;

    BankAccount(int a, double b) {
        accountNumber = a;
        balance = b;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class Q2BankAccount {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(12345, 1000);

        b.deposit(500);
        b.withdraw(300);
        b.checkBalance();
    }
}