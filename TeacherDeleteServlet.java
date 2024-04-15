package Controller;
import DAO.TeacherDAO;
import Model.Teacher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/deleteTeacher")
public class TeacherDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teachers = teacherDAO.getAllTeachers();

        
        request.setAttribute("teachers", teachers);

       
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DeleteTeacher.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));

       
        TeacherDAO teacherDAO = new TeacherDAO();
        Teacher teacher = teacherDAO.searchTeacher(new Teacher(teacherId));
        teacherDAO.deleteTeacher(teacher);

        
        response.sendRedirect(request.getContextPath() + "/deleteTeacher");
    }
}
