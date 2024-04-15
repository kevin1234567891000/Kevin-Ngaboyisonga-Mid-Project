

<%@ page import="java.util.List" %>
<%@ page import="Model.Teacher" %>
<%@ page import="DAO.TeacherDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Teachers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(tcher.png);
        }
        h2 {
            color: #333;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        form {
            display: inline-block;
        }
        input[type="text"],
        input[type="email"] {
            border: 1px solid #ddd;
            padding: 5px;
            border-radius: 4px;
            width: 300px; /* Increased width for the email field */
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>List of Adventist University of Central Africa Teachers</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Qualification</th>
            <th>Action</th>
        </tr>
        <% 
            // Retrieve all teachers from the database
            TeacherDAO teacherDao = new TeacherDAO();
            List<Teacher> teachers = teacherDao.getAllTeachers();
            
            // Iterate over the list of teachers and display each teacher in a row
            for (Teacher teacher : teachers) { 
        %>
        <tr>
            <td><%= teacher.getNames() %></td>
            <td>
                <form action="updateTeacher" method="post">
                    <input type="hidden" name="teacherId" value="<%= teacher.getTeacher_id() %>">
                    <input type="email" name="email" value="<%= teacher.getEmail() %>">
            </td>
            <td>
               <td>
    <input type="text" name="qualification" value="<%= teacher.getQualifications().name() %>">
</td>


            </td>
            <td>
                <input type="submit" value="Update">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>


