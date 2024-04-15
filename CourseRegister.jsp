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
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image:url(bookstd.png);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: skyblue;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        select {
            appearance: none;
            -webkit-appearance: none;
            -moz-appearance: none;
            background-image: url('data:image/svg+xml;utf8,<svg fill="#555" height="24" viewBox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg"><path d="M7 10l5 5 5-5z"/><path d="M0 0h24v24H0z" fill="none"/></svg>');
            background-repeat: no-repeat;
            background-position-x: 95%;
            background-position-y: 50%;
            padding-right: 35px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="registerCourse" method="post">
        <h2>Register Course</h2>
        <label for="courseCode">Course Code:</label>
        <input type="text" id="courseCode" name="courseCode">
        
        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="courseName">
        
        <label for="credit">Credit:</label>
        <input type="number" id="credit" name="credit">
        
        <label for="department">Department:</label>
        <select id="department" name="department">
            <option value="">Select Department</option>
            <% if (retrieveDepartments != null) {
                   for (AcademicUnit unit : retrieveDepartments) {
            %>
            <option value="<%= unit.getId() %>"><%= unit.getName() %></option>
            <% }} %>
        </select>
        
        <label for="semesterId">Semester:</label>
        <select id="semesterId" name="semesterId">
            <option value="">Select Semester</option>
            <% for (Semester unit : allsemesters) { %>
            <option value="<%= unit.getSem_Id() %>"><%= unit.getName() %></option>
            <% } %>
        </select>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
