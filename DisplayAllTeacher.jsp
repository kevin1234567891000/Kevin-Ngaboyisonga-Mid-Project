<%@ page import="java.util.List" %>
<%@ page import="Model.Teacher" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Teachers</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
    </style>
</head>
<body>
    <h2>List of Teachers</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Qualification</th>
        </tr>
        <%-- Retrieve teachers from request attribute --%>
        <% 
            java.util.List<Model.Teacher> teachers = (java.util.List<Model.Teacher>) request.getAttribute("viewTeachers");
            if (teachers != null) {
                // Iterate over the list of teachers and display each teacher in a row
                for (Model.Teacher teacher : teachers) { 
        %>
        <tr>
            <td><%= teacher.getNames() %></td>
            <td><%= teacher.getEmail() %></td>
            <td><%= teacher.getQualifications().name() %></td>
        </tr>
        <% 
                }
            } else {
        %>
        <tr>
            <td colspan="3">No teachers found.</td>
        </tr>
        <% } %>
    </table>
</body>
</html>
