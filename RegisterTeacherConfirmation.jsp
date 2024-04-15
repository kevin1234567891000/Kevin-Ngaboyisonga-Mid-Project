<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url(tcher.png);
        }
        .confirmation {
            width: 40%;
            margin: 200px auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 18px;
        }
        .home-link {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 4px;
            margin-top: 20px;
        }
        .home-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="confirmation">
        <h2>Registration Confirmation</h2>
        <p>The teacher has been successfully registered!</p>
        <a href="TeacherHomepage.html" class="home-link">Go Back To Homepage</a>
    </div>
</body>
</html>
