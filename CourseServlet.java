package Controller;

import DAO.AcademicUDAO;
import DAO.CourseDAO;
import DAO.SemesterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.AcademicUnit;
import Model.Course;
import Model.Semester;

import java.io.IOException;
import java.util.List;

@WebServlet("/registerCourse")
public class CourseServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        String creditStr = request.getParameter("credit");
        String departmentIdStr = request.getParameter("department");
        String semesterIdStr = request.getParameter("semesterId");

        // Convert credit string to integer
        int credit = Integer.parseInt(creditStr);

        // Convert department ID and semester ID to integers
        int departmentId = Integer.parseInt(departmentIdStr);
        int semesterId = Integer.parseInt(semesterIdStr);

        // Create AcademicUnit and Semester objects
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setId(departmentId);

        Semester semester = new Semester();
        semester.setSem_Id(semesterId);

        // Create a Course object
        Course course = new Course();
        course.setCourse_code(courseCode);
        course.setName(courseName);
        course.setCredit(credit);
        course.setAcademicUnit(academicUnit);
        course.setSemester_Course(semester);

        // Create an instance of CourseDao
        CourseDAO courseDao = new CourseDAO();

        // Register the course
        Course registeredCourse = courseDao.registerCourse(course);

        // Check if registration was successful
        if (registeredCourse != null) {
            // Registration successful
            response.getWriter().write("Course registered successfully with ID: " + registeredCourse.getCourse_id());
        } else {
            // Registration failed
            response.getWriter().write("Failed to register course.");
        }
    }
    
    private List<AcademicUnit> retrieveDepartments() {
        // Create an instance of AcademicUnitDao
        AcademicUDAO academicUnitDao = new AcademicUDAO();
        
        // Retrieve list of departments from the database
        return academicUnitDao.getDepartments();
    }
    
    private List<Semester> allsemesters() {
        // Create an instance of AcademicUnitDao
        SemesterDAO semesterDao = new SemesterDAO();
        
        // Retrieve list of departments from the database
        return semesterDao.allsemesters();
    }
    
}
