package Controller;

import java.io.IOException;

import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve login form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a User object with login credentials
        User loginUser = new User();
        loginUser.setEmail(email);
        loginUser.setPassword(password);

        // Authenticate user using UserDao
        UserDAO userDao = new UserDAO();
        loginUser = userDao.login(loginUser);

        if (loginUser != null) {
            // Create cookie with user information
            Cookie userCookie = new Cookie("userInfo", email + ":" + loginUser.getRole());
            userCookie.setMaxAge(24 * 60 * 60); // Cookie expires in 24 hours
            response.addCookie(userCookie);

            // Redirect to the appropriate page based on user role
            if (loginUser.getRole().equalsIgnoreCase("admin")) {
                response.sendRedirect("Homepage.html");
            } else if(loginUser.getRole().equalsIgnoreCase("student")) {
                response.sendRedirect("StudentHomepage.html");
            } else if(loginUser.getRole().equalsIgnoreCase("Teacher")) {
            	response.sendRedirect("TeacherHomepage.html");
            }else {
            	response.sendRedirect("NewStudentSignUp.html?error=Invalid credentials");
            }
            
        } else {
            // Redirect back to login page with error message
            response.sendRedirect("NewStudentLogin.html?error=Invalid credentials");
        }
    }
}