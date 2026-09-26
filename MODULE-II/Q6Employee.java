class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }
}

class EmployeeDetails extends Person {
    String empId;
    double salary;

    EmployeeDetails(String n, int a, String id, double s) {
        super(n, a);
        empId = id;
        salary = s;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }
}

public class Q6Employee {
    public static void main(String[] args) {
        EmployeeDetails e =
            new EmployeeDetails("Alice", 30, "E123", 50000);

        e.display();
    }
}