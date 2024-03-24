package Controller;

import DAO.AcademicUDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.AcademicUnit;
import Model.CourseEnum;

import java.io.IOException;

@WebServlet("/registerAcademicUnit")
public class AcademicServlet extends HttpServlet {

    private static final long serialVersionUID = 1723631643674534063L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String programTypeStr = request.getParameter("programType");
        String parentIdStr = request.getParameter("parentId"); // New parameter for parentId

        // Validate and parse programType
        CourseEnum programType = null;
        try {
            programType = CourseEnum.valueOf(programTypeStr);
        } catch (IllegalArgumentException e) {
            response.getWriter().write("Invalid program type.");
            return;
        }

        // Validate and parse parentId
        Integer parentId = null;
        if (parentIdStr != null && !parentIdStr.isEmpty()) {
            try {
                parentId = Integer.parseInt(parentIdStr);
            } catch (NumberFormatException e) {
                response.getWriter().write("Invalid parent ID format.");
                return;
            }
        }

        // Create an AcademicUnit object
        AcademicUnit academicUnit = new AcademicUnit();
        academicUnit.setCode(code);
        academicUnit.setName(name);
        academicUnit.setProgramType(programType);

        // If parentId is provided, set the parent AcademicUnit
        if (parentId != null) {
            AcademicUnit parentUnit = new AcademicUnit();
            parentUnit.setId(parentId);
            academicUnit.setAcademicUnit(parentUnit);
        }

        // Create an instance of AcademicUnitDao
        AcademicUDAO academicUnitDao = new AcademicUDAO();

        // Register the AcademicUnit
        AcademicUnit registeredUnit = academicUnitDao.register(academicUnit);

        // Check if registration was successful
        if (registeredUnit != null) {
            // Registration successful
            response.getWriter().write("AcademicUnit registered successfully with ID: " + registeredUnit.getId());
        } else {
            // Registration failed
            response.getWriter().write("Failed to register AcademicUnit.");
        }
    }
}
