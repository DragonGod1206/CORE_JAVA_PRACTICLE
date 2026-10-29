
import java.awt.*;
import java.io.Console;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EmployeeManagement extends JFrame {

    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/company_db";

    private static final String DB_USER = "root";

    // Password is entered securely when the program starts.
    private static char[] DB_PASSWORD;

    private final JTextField idField = new JTextField();
    private final JTextField nameField = new JTextField();
    private final JTextField departmentField = new JTextField();
    private final JTextField salaryField = new JTextField();

    private final DefaultTableModel tableModel =
            new DefaultTableModel(
                    new String[]{
                        "Employee ID", "Name", "Department", "Salary"
                    }, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

    private final JTable employeeTable = new JTable(tableModel);

    public EmployeeManagement() {
        setTitle("Employee Management System");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel(
                "Employee Management System",
                SwingConstants.CENTER
        );
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBorder(new EmptyBorder(15, 5, 10, 5));

        add(heading, BorderLayout.NORTH);

        // Employee input form.
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("Employee ID:"));
        formPanel.add(idField);

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Salary:"));
        formPanel.add(salaryField);

        // Application buttons.
        JButton submitButton = new JButton("Submit");
        JButton viewButton = new JButton("View All Employees");

        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 5)
        );
        buttonPanel.add(submitButton);
        buttonPanel.add(viewButton);

        JPanel formSection = new JPanel(new BorderLayout(10, 10));
        formSection.add(formPanel, BorderLayout.CENTER);
        formSection.add(buttonPanel, BorderLayout.SOUTH);

        // Employee records table.
        employeeTable.setRowHeight(24);
        employeeTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        employeeTable.setFillsViewportHeight(true);

        JPanel content = new JPanel(new BorderLayout(10, 15));
        content.setBorder(new EmptyBorder(10, 20, 20, 20));
        content.add(formSection, BorderLayout.NORTH);
        content.add(new JScrollPane(employeeTable), BorderLayout.CENTER);

        add(content, BorderLayout.CENTER);

        // Button actions.
        submitButton.addActionListener(e -> saveEmployee());
        viewButton.addActionListener(e -> loadEmployees());

        // Load existing employee records when the window opens.
        loadEmployees();
    }

    // Connect Java to the company_db MySQL database.
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(
                DB_URL, DB_USER, new String(DB_PASSWORD)
        );
    }

    // Insert a new employee record.
    private void saveEmployee() {
        String idText = idField.getText().trim();
        String name = nameField.getText().trim();
        String department = departmentField.getText().trim();
        String salaryText = salaryField.getText().trim();

        if (idText.isEmpty() || name.isEmpty()
                || department.isEmpty() || salaryText.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this, "Please fill in all fields."
            );
            return;
        }

        try {
            int empId = Integer.parseInt(idText);
            BigDecimal salary = new BigDecimal(salaryText);

            if (salary.signum() < 0) {
                JOptionPane.showMessageDialog(
                        this, "Salary cannot be negative."
                );
                return;
            }

            String sql = "INSERT INTO employees "
                    + "(emp_id, name, department, salary) "
                    + "VALUES (?, ?, ?, ?)";

            try (Connection connection = connect();
                 PreparedStatement statement =
                         connection.prepareStatement(sql)) {

                statement.setInt(1, empId);
                statement.setString(2, name);
                statement.setString(3, department);
                statement.setBigDecimal(4, salary);

                statement.executeUpdate();

                JOptionPane.showMessageDialog(
                        this, "Employee added successfully!"
                );

                clearFields();
                loadEmployees();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Employee ID must be an integer and salary "
                    + "must be a valid decimal number.",
                    "Invalid Input",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Could not save employee:\n" + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Retrieve and display all employee records.
    private void loadEmployees() {
        String sql = "SELECT emp_id, name, department, salary "
                + "FROM employees ORDER BY emp_id";

        tableModel.setRowCount(0);

        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)) {

            while (result.next()) {
                tableModel.addRow(new Object[]{
                    result.getInt("emp_id"),
                    result.getString("name"),
                    result.getString("department"),
                    result.getBigDecimal("salary")
                });
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Could not load employees:\n" + ex.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Clear the input fields after a successful insertion.
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        departmentField.setText("");
        salaryField.setText("");
        idField.requestFocusInWindow();
    }

    public static void main(String[] args) {

        Console console = System.console();

        // A real console is required to hide password characters.
        if (console == null) {
            System.err.println(
                    "No terminal console detected."
            );
            System.err.println(
                    "Run this program directly from the VS Code "
                    + "integrated terminal using the java command."
            );
            return;
        }

        char[] enteredPassword =
                console.readPassword("Enter MySQL root password: ");

        if (enteredPassword == null || enteredPassword.length == 0) {
            System.err.println("Password cannot be empty.");
            return;
        }

        DB_PASSWORD = enteredPassword.clone();
        Arrays.fill(enteredPassword, '\0');

        // Verify the database connection before opening the window.
        try (Connection connection =
                     DriverManager.getConnection(
                             DB_URL, DB_USER, new String(DB_PASSWORD))) {

            System.out.println(
                    "Database connection successful!"
            );

        } catch (SQLException ex) {
            System.err.println(
                    "Database connection failed: " + ex.getMessage()
            );
            Arrays.fill(DB_PASSWORD, '\0');
            DB_PASSWORD = null;
            return;
        }

        SwingUtilities.invokeLater(() -> {
            EmployeeManagement app = new EmployeeManagement();
            app.setVisible(true);
        });
    }
}
