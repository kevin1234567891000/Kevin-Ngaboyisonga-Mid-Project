package Controller;

import Model.Semester;
import DAO.SemesterDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerSemester")
public class semesterServ extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle parsing exception
        }

        Semester semester = new Semester();
        semester.setName(name);
        semester.setStartDate(startDate);
        semester.setEndDate(endDate);

        SemesterDAO semesterDAO = new SemesterDAO();
        Semester registeredSemester = semesterDAO.register(semester);

        if (registeredSemester != null) {
            response.getWriter().println("Semester registered successfully.");
        } else {
            response.getWriter().println("Error registering semester.");
        }
    }
}
