<%@ page import="java.util.List" %>
<%@ page import="Model.Teacher" %>
<%@ page import="DAO.TeacherDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Teacher</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: skyblue;
        }
        h2 {
            color: green;
            text-align:center;
            
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
        input[type="submit"] {
            background-color: #e74c3c;
            color: white;
            padding: 8px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
        input[type="submit"]:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <h2>DELETE TEACHER</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Qualification</th>
            <th>Course</th>
            <th>Action</th>
        </tr>
        <% 
           
            TeacherDAO teacherDAO = new TeacherDAO();
            List<Teacher> teachers = teacherDAO.getAllTeachers();
            
            
            for (Teacher teacher : teachers) { 
        %>
        <tr>
            <td><%= teacher.getTeacher_id() %></td>
            <td><%= teacher.getNames() %></td>
            <td><%= teacher.getEmail() %></td>
            <td><%= teacher.getQualifications() %></td>
            <td><%= teacher.getCourses() != null ? teacher.getCourses().getName() : "" %></td>
            <td>
                <form action="deleteTeacher" method="post">
                    <input type="hidden" name="teacherId" value="<%= teacher.getTeacher_id() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
