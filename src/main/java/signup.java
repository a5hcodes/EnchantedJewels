import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

public class signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving user inputs from the signup form
        String name = request.getParameter("name");
        String num = request.getParameter("num");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String pass = request.getParameter("pwd");



        try {
            // Assuming you have a method to get the database connection
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();


            // Query to insert new user into the QuickCart_users table
            String insertQuery = "INSERT INTO user_info (username, contact, gender, email, password) VALUES ('" + name + "', '" + num + "', '" + gender + "', '" + email + "', '" + pass + "')";


            int rowsAffected = stmt.executeUpdate(insertQuery);

            if (rowsAffected > 0) {

                HttpSession session = request.getSession();
                session.setAttribute("username", name);

                Cookie userCookie = new Cookie("username", name);
                userCookie.setMaxAge(60 * 60 * 24 * 30);
                response.addCookie(userCookie);

                // Signup successful
                response.sendRedirect("login.jsp");
                out.println("<script> alert('You have successfully Logged in! :>')");
                        } else {
                // Signup failed
                response.sendRedirect("sign.jsp");
                out.println("<script> alert('You might have to check your email and passwords or perhaps create an account :>')");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
        }
} }