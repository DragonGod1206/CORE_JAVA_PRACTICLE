# Employee Management System

A Java Swing desktop app for adding employee records to MySQL and viewing them
in a table. These instructions are for someone who has downloaded the project
ZIP and is setting it up on a Windows computer.

## What you need

Install these before running the app:

1. **JDK 21** (or newer). Install a JDK, not just a JRE. Open PowerShell and
   check that both commands work:
   ```powershell
   java -version
   javac -version
   ```
   If either command is not recognized, install a JDK and reopen PowerShell.
2. **MySQL Server 8.4**. Install and start the MySQL service. You will need the
   MySQL username and password. The example below uses `root`.

You do not need to install VS Code. The included MySQL Connector/J driver is in
the ZIP under `lib`.

## 1. Extract the ZIP

In File Explorer, right-click the downloaded ZIP and select **Extract All**.
Open the extracted `Module6_EmployeeManagement` folder. It should contain:

```text
README.md
src\EmployeeManagement.java
lib\mysql-connector-j-26.10.0.jar
```

Keep the `src` and `lib` folders together. The generated `out` folder does not
need to be included in the ZIP; it is created during compilation.

## 2. Create the database and table

Open PowerShell and connect to MySQL. For the default MySQL Server 8.4 Windows
installation, run:

```powershell
& "C:\Program Files\MySQL\MySQL Server 8.4\bin\mysql.exe" -u root -p
```

Enter the MySQL password when prompted. At the `mysql>` prompt, paste and run:

```sql
CREATE DATABASE IF NOT EXISTS company_db;
USE company_db;
CREATE TABLE IF NOT EXISTS employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DECIMAL(10,2)
);
```

Then type `exit` and press Enter. If `mysql.exe` is not at the path above,
locate it in your MySQL installation and substitute that path.

The app connects to `localhost` on port `3306`, database `company_db`, using
the MySQL username `root`. That account must have permission to select and
insert rows in `company_db.employees`.

## 3. Compile the application

In File Explorer, open the extracted project folder. Click the address bar,
type `powershell`, and press Enter. This opens PowerShell in the project
directory. Alternatively, open PowerShell and change to the extracted folder
with `cd "C:\path\to\Module6_EmployeeManagement"`.

Run these commands from that folder:

```powershell
New-Item -ItemType Directory -Force out
javac -cp "lib\mysql-connector-j-26.10.0.jar" -d out src\EmployeeManagement.java
```

If compilation succeeds, PowerShell returns to the prompt without errors.

## 4. Start the application

In the same PowerShell window, run:

```powershell
java -cp "out;lib\mysql-connector-j-26.10.0.jar" EmployeeManagement
```

Type the MySQL password when asked. Password characters are hidden while
typing. A successful connection prints `Database connection successful!` and
opens the Employee Management window.

**Important:** Run this command in a real terminal, such as PowerShell or the
VS Code integrated terminal. The app reads the password using the terminal
console, so it will not work from the VS Code Debug Console or some code-runner
extensions.

## 5. Use the application

1. Enter an integer employee ID, name, department, and salary.
2. Click **Submit** to save the employee.
3. Click **View All Employees** to refresh the table.

Example values:

| Field | Example |
|---|---|
| Employee ID | `101` |
| Name | `Rahul Sharma` |
| Department | `IT` |
| Salary | `45000.00` |

The app checks that all fields are filled, the employee ID is an integer, and
the salary is a valid non-negative decimal. IDs must be unique because the
database uses `emp_id` as its primary key. Saved records remain in MySQL when
you close the app.

## Running it again later

After the first successful compile, you do not need to compile again unless the
Java source changes. Start MySQL, open PowerShell in the extracted project
folder, and run:

```powershell
java -cp "out;lib\mysql-connector-j-26.10.0.jar" EmployeeManagement
```

Enter the database password when prompted.

## Troubleshooting

### `java` or `javac` is not recognized

Install a JDK and make sure its `bin` directory is on your Windows `PATH`.
Close and reopen PowerShell after installing or changing `PATH`.

### `The system cannot find the path specified` for `mysql.exe`

The MySQL client is installed in a different location. Find `mysql.exe` and
replace the path in the database connection command with its actual location.

### `Access denied for user`

Check the MySQL username and password. Make sure that user can access
`company_db` and has permission to select and insert employee records.

### `Communications link failure`

Make sure the MySQL Server service is running and listening on port `3306`.

### `No suitable driver found`

Check that `lib\mysql-connector-j-26.10.0.jar` exists and that the classpath
commands above were run from the project folder.

### Duplicate entry

That employee ID is already in use. Enter a different ID.

### `No terminal console detected`

Run the `java` command directly in PowerShell or another interactive terminal,
not the Debug Console or a code-runner extension.

## Project details

- **Language/UI:** Java 21 and Swing
- **Database access:** JDBC with the included MySQL Connector/J driver
- **Database:** MySQL `company_db`, table `employees`
- **Source file:** `src\EmployeeManagement.java`
