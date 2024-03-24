package Controller;

import Model.Student;
import DAO.StudentDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerStudent")
public class StudentRegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regNo = request.getParameter("regNo");
        String name = request.getParameter("name");
        String dobStr = request.getParameter("dob");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;
        try {
            dob = sdf.parse(dobStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception
        }

        Student student = new Student();
        student.setRegNo(regNo);
        student.setName(name);
        student.setDateOfBirth(dob);

        StudentDAO studentDAO = new StudentDAO();
        Student registeredStudent = studentDAO.register(student);

        if (registeredStudent != null) {
            response.getWriter().println("Student registered successfully.");
        } else {
            response.getWriter().println("Error registering student.");
        }
    }
}
