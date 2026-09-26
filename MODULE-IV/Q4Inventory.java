import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

class Inventory {
    HashMap<Integer, Integer> products = new HashMap<>();

    void addProduct(int productId, int stock) {
        products.put(productId, stock);
        System.out.println(
            "Product " + productId + " added with stock " + stock
        );
    }

    void updateStock(int productId, int stock) {
        if (products.containsKey(productId)) {
            products.put(productId, stock);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        Iterator<Map.Entry<Integer, Integer>> iterator =
            products.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();

            System.out.println(
                "Product ID: " + entry.getKey() +
                " | Stock: " + entry.getValue()
            );
        }
    }
}

public class Q4Inventory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();

                System.out.print("Enter Stock: ");
                int stock = sc.nextInt();

                inventory.addProduct(productId, stock);

            } else if (choice == 2) {
                System.out.print("Enter Product ID: ");
                int productId = sc.nextInt();

                System.out.print("Enter New Stock: ");
                int stock = sc.nextInt();

                inventory.updateStock(productId, stock);

            } else if (choice == 3) {
                inventory.displayInventory();

            } else if (choice == 4) {
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}