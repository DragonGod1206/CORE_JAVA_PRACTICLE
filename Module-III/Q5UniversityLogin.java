import java.util.Scanner;

class UniversityLogin {
    void login(String username) {
        if (username.equals("null") || username == null) {
            throw new NullPointerException("Username cannot be null");
        }

        System.out.println("Login successful");
    }
}

public class Q5UniversityLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        UniversityLogin obj = new UniversityLogin();

        try {
            obj.login(username);
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}