<%@ page import="java.util.List" %>
<%@ page import="Model.AcademicUnit" %>
<%@ page import="DAO.AcademicUDAO" %>
<%@ page import="Model.CourseEnum" %>

<%
    AcademicUDAO academicUnitDao = new AcademicUDAO();
    List<AcademicUnit> allAcademicUnits = academicUnitDao.getAllAcademicUnits();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Register Academic Unit</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: skyblue;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width:400px;
            padding:40px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            appearance: none;
            background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='12' height='6' fill='%23999'%3E%3Cpath d='M6 5l4-4H2z'/%3E%3C/svg%3E");
            background-repeat: no-repeat;
            background-position-x: calc(100% - 10px);
            background-position-y: center;
            background-size: 12px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register Academic Unit</h2>
        <form action="registerAcademicUnit" method="post">
            <label for="code">Code:</label><br>
            <input type="text" id="code" name="code"><br>
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <label for="programType">Program Type:</label><br>
            <select id="programType" name="programType">
                <option value="FACULTY">Faculty</option>
                <option value="PROGRAMME">Programme</option>
                <option value="DEPARTMENT">Department</option>
            </select><br>
            <label for="parentId">Parent Academic Unit:</label><br>
            <select id="parentId" name="parentId">
                <option value="">Select Parent Academic Unit</option>
                <!-- Populate the dropdown with academic units -->
                <% 
                    if (allAcademicUnits != null) {
                        for (AcademicUnit unit : allAcademicUnits) {
                %>
                <option value="<%= unit.getId() %>"><%= unit.getName() %></option>
                <% 
                        }
                    }
                %>
            </select><br>
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
