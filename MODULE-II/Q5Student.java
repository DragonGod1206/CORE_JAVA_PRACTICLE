class Student {
    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String n, int a) {
        name = n;
        age = a;
    }

    Student(Student s) {
        name = s.name;
        age = s.age;
    }

    void display(String type) {
        System.out.println(type + ": " + name + ", " + age);
    }
}

public class Q5Student {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.display("Default Constructor");

        Student s2 = new Student("John", 20);
        s2.display("Parameterized Constructor");

        Student s3 = new Student(s2);
        s3.display("Copy Constructor");
    }
}