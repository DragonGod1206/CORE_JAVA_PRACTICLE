import java.util.LinkedHashSet;
import java.util.Scanner;

class CourseEnrollment {
    LinkedHashSet<String> students = new LinkedHashSet<>();

    void enrollStudent(String name) {
        if (students.add(name)) {
            System.out.println("Enrolled: " + name);
        } else {
            System.out.println(name + " is already enrolled");
        }
    }

    void displayEnrolledStudents() {
        System.out.println("Enrolled Students: " + students);
    }
}

public class Q5CourseEnrollment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseEnrollment course = new CourseEnrollment();

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enroll: ");
            String name = sc.nextLine();
            course.enrollStudent(name);
        }

        course.displayEnrolledStudents();

        sc.close();
    }
}