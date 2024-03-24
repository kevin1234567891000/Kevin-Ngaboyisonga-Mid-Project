<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Background image styling */
        body {
            background-image: url(download.jpg);
            background-size: cover;
            height: 100vh;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        /* Form container styling */
        .form-container {
            background-color: cyan; /* Semi-transparent white background */
            padding: 70px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Shadow effect */
            color: red; /* Text color */
            width: 500px; /* Increased width */
        }
        /* Sidebar styling */
        .sidebar .nav-link {
            color: blue; /* Link color */
            font-weight: bold; /* Bold font */
        }
        .sidebar .nav-link:hover {
            background-color: #f0f0f0; /* Light gray background on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="form-container">
                <!-- Sidebar -->
                <nav class="sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    ADMINISTRATION DASHBOARD
                                </a>
                            </li>
                            <!-- Add your form items here -->
                             <li class="nav-item">
                <a class="nav-link" href="SemesterRegist.html">
                    Semester
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="StudentRegister.html">
                   Add Student
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Academic.jsp">
                    Academic Unit
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="TeacherRegister.html">
                     Add Teacher
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="studentReg.jsp">
                   Add Course
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Registration.jsp">
                    Student Registration
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="academicUnit.jsp">
                    Course Description
                </a>
            </li>
                            <!-- End of form items -->
                        </ul>
                    </div>
                </nav>
                <!-- End of Sidebar -->
            </div>
        </div>
    </div>
</div>
</body>
</html>
