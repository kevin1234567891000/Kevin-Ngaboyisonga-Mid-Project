<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Qualification" %>

<html>
<head>
    <title>Register Teacher</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(tcher.png);
        }
        h2 {
            color: golden;
            text-align:center;
        }
        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Register Teacher</h2>
    <form action="registerTeacher" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        
        <label for="qualification">Qualification:</label>
        <select id="qualification" name="qualification" required>
            <option value="">Select Qualification</option>
            <% 
                for (Qualification qual : Qualification.values()) {
            %>
            <option value="<%= qual.name() %>"><%= qual.name() %></option>
            <% 
                }
            %>
        </select><br>
        
        <label for="courseId">Course ID:</label>
        <input type="text" id="courseId" name="courseId">
        
        <input type="submit" value="Register Teacher">
    </form>
</body>
</html>
