package Controller;


import DAO.TeacherDAO;
import Model.Teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/viewTeachers")
public class DisplayTeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 int teacherId = Integer.parseInt(request.getParameter("teacherId"));
         String email = request.getParameter("email");
         String qualificationName = request.getParameter("qualification");

        // Retrieve all teachers from the database
        TeacherDAO teacherDao = new TeacherDAO();
        List<Teacher> teachers = teacherDao.getAllTeachers();

        // Check if the list of teachers is not null before setting it as a request attribute
        if (teachers != null) {
            // Forward the list of teachers to a JSP page for display
            request.setAttribute("viewTeachers", teachers);
            request.getRequestDispatcher("DisplayAllTeacher.jsp").forward(request, response);
        } else {
            // Handle the case where the list of teachers is null (e.g., database error)
            // You can redirect to an error page or handle it according to your application's logic
            response.sendRedirect("500.html");
        }
    }
}
