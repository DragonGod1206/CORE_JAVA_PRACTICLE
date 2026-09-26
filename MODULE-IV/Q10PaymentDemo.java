abstract class Payment {
    abstract void pay(double amount);
}

class CreditCardPayment extends Payment {
    void pay(double amount) {
        System.out.println("Credit Card Payment: " + amount);
    }
}

class UPIPayment extends Payment {
    void pay(double amount) {
        System.out.println("UPI Payment: " + amount);
    }
}

public class Q10PaymentDemo {
    public static void main(String[] args) {
        Payment p = new CreditCardPayment();
        p.pay(500);

        p = new UPIPayment();
        p.pay(300);
    }
}