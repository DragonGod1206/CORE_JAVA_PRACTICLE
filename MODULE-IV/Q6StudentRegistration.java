import java.awt.*;
import java.awt.event.*;

class StudentRegistration extends Frame implements ActionListener {
    Label nameLabel, rollLabel, courseLabel;
    TextField nameField, rollField, courseField;
    Button submit;

    StudentRegistration() {
        setTitle("Student Registration Form");

        setLayout(new FlowLayout());

        nameLabel = new Label("Name:");
        rollLabel = new Label("Roll No:");
        courseLabel = new Label("Course:");

        nameField = new TextField(20);
        rollField = new TextField(20);
        courseField = new TextField(20);

        submit = new Button("Submit");

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(courseLabel);
        add(courseField);

        add(submit);

        submit.addActionListener(this);

        setSize(300, 200);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String details =
            "Registration Successful!\n\n" +
            "Name: " + nameField.getText() + "\n" +
            "Roll No: " + rollField.getText() + "\n" +
            "Course: " + courseField.getText();

        Dialog dialog = new Dialog(this, "Registration Details", true);
        dialog.setLayout(new FlowLayout());

        TextArea area = new TextArea(details, 8, 30);
        Button ok = new Button("OK");

        dialog.add(area);
        dialog.add(ok);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.setSize(350, 250);
        dialog.setVisible(true);
    }
}

public class Q6StudentRegistration {
    public static void main(String[] args) {
        new StudentRegistration();
    }
}