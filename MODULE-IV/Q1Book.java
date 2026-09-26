class Book {
    String title, author;
    double price;

    void setDetails(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class Q1Book {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book();

        b1.setDetails("Java Basics", "John Smith", 500);
        b2.setDetails("Python Essentials", "Mary John", 650);

        b1.display();
        b2.display();
    }
}