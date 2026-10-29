package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {
    private static final DateTimeFormatter DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("MMMM d, uuuu 'at' h:mm:ss a");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String name = escapeHtml(request.getParameter("name"));
        String email = escapeHtml(request.getParameter("email"));
        String feedbackType = escapeHtml(request.getParameter("feedbackType"));
        String comments = escapeHtml(request.getParameter("comments"));
        String submittedAt = LocalDateTime.now().format(DATE_TIME_FORMAT);

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("  <meta charset=\"UTF-8\">");
            out.println("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("  <title>Feedback received</title>");
            out.println("  <style>");
            out.println("    body{font-family:system-ui,-apple-system,'Segoe UI',sans-serif;background:#f3f6fb;color:#172033;margin:0;padding:48px 20px}");
            out.println("    main{box-sizing:border-box;width:min(100%,620px);margin:0 auto;padding:36px;border:1px solid #e1e7f0;border-radius:16px;background:#fff;box-shadow:0 16px 40px rgb(23 32 51 / 8%)}");
            out.println("    h1{margin-top:0} dt{font-weight:700;margin-top:18px} dd{margin:6px 0 0;white-space:pre-wrap;overflow-wrap:anywhere;color:#46536a}");
            out.println("    a{display:inline-block;margin-top:28px;color:#305fdb;font-weight:600}");
            out.println("  </style>");
            out.println("</head>");
            out.println("<body><main>");
            out.println("  <h1>Thank you, " + name + " for your feedback!</h1>");
            out.println("  <dl>");
            out.println("    <dt>Email</dt><dd>" + email + "</dd>");
            out.println("    <dt>Feedback type</dt><dd>" + feedbackType + "</dd>");
            out.println("    <dt>Comments</dt><dd>" + comments + "</dd>");
            out.println("    <dt>Submitted</dt><dd>" + escapeHtml(submittedAt) + "</dd>");
            out.println("  </dl>");
            out.println("  <a href=\"feedback.html\">Send more feedback</a>");
            out.println("</main></body></html>");
        }
    }

    private static String escapeHtml(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }
}
