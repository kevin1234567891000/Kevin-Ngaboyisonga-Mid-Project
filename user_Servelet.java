package Controller;

import DAO.UserDAO;
import Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/user_Servelet")
public class user_Servelet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String rol = request.getParameter("roles");

        User use = new User();
        use.setEmail(email);
        use.setPassword(pass);
        use.setRole(rol);
        UserDAO dao = new UserDAO();
        String result = String.valueOf(dao.register(use));
        if(result!=null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("NewStudentLogin.html");
            dispatcher.forward(request, response);
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("NewStudentSignUp.html");
            dispatcher.forward(request, response);
        }
    }
}
