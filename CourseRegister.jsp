
<%@ page import="Model.AcademicUnit" %>
<%@ page import="Model.Semester" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.AcademicUDAO" %>
<%@ page import="DAO.SemesterDAO" %>
<%
    AcademicUDAO academicUnitDao = new AcademicUDAO();
    List<AcademicUnit> retrieveDepartments = academicUnitDao.getDepartments();;
%>

<%
    SemesterDAO semesterDao = new SemesterDAO();
    List<Semester> allsemesters = semesterDao.allsemesters();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Register Course</title>
</head>
<body>
    <h2>Register Course</h2>
    <form action="registerCourse" method="post">
        <label for="courseCode">Course Code:</label><br>
        <input type="text" id="courseCode" name="courseCode"><br>
        
        <label for="courseName">Course Name:</label><br>
        <input type="text" id="courseName" name="courseName"><br>
        
        <label for="credit">Credit:</label><br>
        <input type="number" id="credit" name="credit"><br>
        
        <label for="department">Department:</label><br>
        <select id="department" name="department">
            <option value="">Select Department</option>
          <%
    if (retrieveDepartments != null) {
        for (AcademicUnit unit : retrieveDepartments) {
%>
<option value="<%= unit.getId() %>"><%= unit.getName() %></option>
<%
        }
    }
%>

            
        </select><br>
        <label for="department">Semester:</label><br>
        <select id="semesterId" name="semesterId">
            <option value="">Select Semester</option>
            
            <% 
                for (Semester unit : allsemesters) {
            %>
            <option value="<%= unit.getSem_Id() %>"><%= unit.getName() %></option>
            <% 
                }
            %>
            
        </select><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>

