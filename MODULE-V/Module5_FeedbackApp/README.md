# FeedbackApp

A small Java Servlet feedback form packaged as a WAR for Apache Tomcat 9.

## Project layout

```text
pom.xml
src/
  com/
    example/
      FeedbackServlet.java
web/
  feedback.html
  WEB-INF/
    web.xml
```

Maven compiles the servlet and packages the contents of `web` into
`target\FeedbackApp.war`. Tomcat serves the form and runs the servlet when the
form is submitted.

## Requirements

Install these on the Windows PC:

1. **Java JDK 8 or later.** Java 21 LTS is a suitable choice. This project
   compiles for Java 8 bytecode.
2. **Apache Maven 3.6.3 or later.**
3. **Apache Tomcat 9.** The application uses `javax.servlet`; Tomcat 10 or
   later uses `jakarta.servlet` and is not compatible without changing the app.

Make sure `java` and `mvn` are available in PowerShell. Check with:

```powershell
java -version
mvn -version
```

The Maven command should report that it is using the installed JDK.

## Build the WAR

1. Copy the complete project folder to the PC. Keep `pom.xml`, `src`, and `web`
   together; do not copy the `target` folder because Maven creates it.
2. Open PowerShell and change to the project folder—the folder containing
   `pom.xml`. For example:

   ```powershell
   cd "C:\Users\YourName\Documents\Module5_FeedbackApp"
   ```

3. Build the application:

   ```powershell
   mvn clean package
   ```

   The first build may need an internet connection so Maven can download the
   Servlet API and Maven plugins.
4. Confirm the build succeeded and that this file exists:

   ```text
   target\FeedbackApp.war
   ```

## Deploy and run with Tomcat

1. Find the Tomcat 9 installation directory. It contains folders such as
   `bin` and `webapps`.
2. Copy `target\FeedbackApp.war` into Tomcat's `webapps` folder. For example:

   ```text
   C:\apache-tomcat-9.0.x\webapps\FeedbackApp.war
   ```

   If Windows denies permission to copy there, install Tomcat in a folder your
   account can write to, or use an account with permission.
3. Start Tomcat by running its `bin\startup.bat`. For example, from PowerShell:

   ```powershell
   & "C:\apache-tomcat-9.0.x\bin\startup.bat"
   ```

   Replace the example path with the actual Tomcat installation path. Tomcat
   automatically expands the WAR into a `FeedbackApp` folder under `webapps`.
4. On that same PC, open:

   [http://localhost:8080/FeedbackApp/feedback.html](http://localhost:8080/FeedbackApp/feedback.html)

   Enter the required fields and submit the form. The servlet displays the
   submitted feedback and the submission time. Feedback is displayed in the
   response; this app does not save it to a database.

Tomcat uses port `8080` by default. If its port is configured differently,
replace `8080` in the URL with the configured port. Use the `feedback.html`
path; the app does not define a welcome page for the shorter `/FeedbackApp/`
URL.

## Stop Tomcat

Run Tomcat's `bin\shutdown.bat`. For example, from PowerShell:

```powershell
& "C:\apache-tomcat-9.0.x\bin\shutdown.bat"
```

## Deploy an updated build

1. Stop Tomcat with `shutdown.bat`.
2. Run `mvn clean package` again from the project folder.
3. Replace `webapps\FeedbackApp.war` with the newly built
   `target\FeedbackApp.war`.
4. If Tomcat still serves an older deployment, remove the old
   `webapps\FeedbackApp` expanded folder after stopping Tomcat.
5. Start Tomcat again with `startup.bat`.

## Troubleshooting

- **`mvn` or `java` is not recognized:** install Maven or a JDK, then add its
  `bin` folder to `PATH` (and configure `JAVA_HOME` for the JDK). Open a new
  PowerShell window and rerun the version checks.
- **The build fails:** run `mvn clean package` from the directory containing
  `pom.xml`, and check that `mvn -version` reports a JDK.
- **The page cannot be reached:** make sure Tomcat started successfully, check
  that port `8080` is available, and confirm the WAR is in Tomcat's `webapps`
  folder.
- **HTTP 404:** use
  `http://localhost:8080/FeedbackApp/feedback.html` and check Tomcat's startup
  output or logs for deployment errors.
- **Servlet API or `javax.servlet` errors:** verify that the server is Tomcat 9,
  not Tomcat 10 or later.
