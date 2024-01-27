import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving user inputs from the login form
        String uemail = request.getParameter("email");
        String upass = request.getParameter("pwd");
        try {
            // Assuming you have a method to get the database connection
            Connection con = DbConnection.getConnection();
            Statement stmt = con.createStatement();

            // Query to check if the user with the provided email and password exists
            String loginQuery = "SELECT * FROM user_info WHERE email = '" + uemail + "' AND password = '" + upass + "'";
            ResultSet rs = stmt.executeQuery(loginQuery);


            if (rs.next()) {
                // User authenticated
                // You might want to store user information in session for future use
                HttpSession session = request.getSession();
                session.setAttribute("email", uemail);

                String username = uemail.split("@")[0];

                request.setAttribute("name", username);
                response.sendRedirect("index.jsp");
            } else {
                // Authentication failed
                response.sendRedirect("login.jsp");
                out.println("<script>alert('Login failed. Check your email and password.');</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}