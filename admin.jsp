<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
       
        body {
            background-image: url(download.jpg);
            background-size: cover;
            height: 100vh;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
        }
       
        .form-container {
    background-color: cyan;
    padding: 90px;
    border-radius: 50px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    color: red;
    width: 100%; 
    max-width: 800px; 
    margin: 0 auto; 
}

        
        .sidebar .nav-link {
            color: blue; 
            font-weight: bold;
        }
        .sidebar .nav-link:hover {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="form-container">
               
                <nav class="sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    ADMINISTRATION DASHBOARD
                                </a>
                            </li>
                            
                             <li class="nav-item">
                <a class="nav-link" href="RegisterTeacher.jsp">
                    Register Teacher
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="DeleteTeacher.jsp">
                   Delete Teacher
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="DisplayTeachers.jsp">
                   Display Teachers
                </a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link" href="Academi.jsp">
                    Academic Unit
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="SemesterRegist.html">
                     Register Semester
                </a>
            </li>
           
            <li class="nav-item">
                <a class="nav-link" href="CourseRegister.jsp">
                   Register Course
                </a>
            </li>
            
                            
                        </ul>
                    </div>
                </nav>
               
            </div>
        </div>
    </div>
</div>
</body>
</html>
