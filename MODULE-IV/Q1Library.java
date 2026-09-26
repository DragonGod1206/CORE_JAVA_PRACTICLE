import java.util.ArrayList;
import java.util.Scanner;

class Library {
    ArrayList<String> books = new ArrayList<>();

    void addBook(String book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    void removeBook(String book) {
        if (books.remove(book)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    void displayBooks() {
        System.out.println("Current Books:");
        for (String book : books) {
            System.out.println(book);
        }
    }
}

public class Q1Library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String book = sc.nextLine();
                library.addBook(book);

            } else if (choice == 2) {
                System.out.print("Enter book title to remove: ");
                String book = sc.nextLine();
                library.removeBook(book);

            } else if (choice == 3) {
                library.displayBooks();

            } else if (choice == 4) {
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}