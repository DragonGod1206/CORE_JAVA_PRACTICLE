import java.util.HashMap;
import java.util.Scanner;

class BankDirectory {
    HashMap<Integer, String> accounts = new HashMap<>();

    void addAccount(int accountNo, String name) {
        accounts.put(accountNo, name);
        System.out.println("Account added successfully.");
    }

    void getCustomer(int accountNo) {
        if (accounts.containsKey(accountNo)) {
            System.out.println(
                "Account No: " + accountNo + " -> " + accounts.get(accountNo)
            );
        } else {
            System.out.println("Account not found.");
        }
    }

    void displayAll() {
        for (Integer accountNo : accounts.keySet()) {
            System.out.println(
                "Account No: " + accountNo + " → " + accounts.get(accountNo)
            );
        }
    }
}

public class Q3BankDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankDirectory bank = new BankDirectory();

        while (true) {
            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Account No: ");
                int accountNo = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                bank.addAccount(accountNo, name);

            } else if (choice == 2) {
                System.out.print("Enter Account No: ");
                int accountNo = sc.nextInt();
                bank.getCustomer(accountNo);

            } else if (choice == 3) {
                bank.displayAll();

            } else if (choice == 4) {
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}