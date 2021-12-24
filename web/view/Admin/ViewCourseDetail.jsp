<%-- 
    Document   : ViewCourseDetail
    Created on : 23-08-2021, 10:43:55
    Author     : mangn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="../../css/Admin/course.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {
                var value = $("#getid").text()
                console.log(value)
                $.ajax({
                    url: "../../CourseController?ac=viewCD",
                    method: "POST",
                    data: {getid: value},
                    success: function (data) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                            $('#cc').text(obj.Course_Cate_ID)
                            $('#topic').text(obj.TopicID)
                            $('#trainer').text(obj.UserID)
                            $('#time').text(obj.CourseTime)
                            $('#sche').text(obj.CourseSchedule)
                            $('#room').text(obj.CourseRoom)
                            $('#stt').text(obj.CourseStatus)
                            $('#des').text(obj.CourseDes)
                            $('#content').text(obj.CourseContent)
                    },
                    error: function () {
                        alert("error");
                    }
                });
            });
        </script>
    </head>
    <body>
        <img src="../../img/img-logo-fe.png">
        <div class="container-fluit">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="index.jsp"><i class="fas fa-home"> Home</i></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="trainee.jsp"><i class="fas fa-user-graduate"> Trainee</i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="trainer.jsp"><i class="fas fa-chalkboard-teacher"> Trainer</i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="staff.jsp"><i class="fas fa-user-edit"> Staff</i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="course-cate.jsp"><i class="fas fa-box"> Course category</i></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="topic.jsp"><i class="fas fa-file-contract"> Topic</i></a>
                        </li>
                        <li class="nav-item" style="background-color: rgb(119, 163, 204);">
                            <a class="nav-link" href="course.jsp"><i class="fas fa-book-reader"> Course</i></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="account.jsp"><i class="fas fa-user-circle"> Account</i></a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="account.jsp"> <i class="fas fa-user-circle"> Account</i></a>
                                <a class="dropdown-item" href="logout.jsp"><i class="fas fa-sign-out-alt"> Log out</i></a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <br>
        <h1 style="text-align: center">Course details</h1>
        <br>
        <h1 id="getid" style="display: none"><%=request.getParameter("id")%></h1>
        <div class="container" >
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Course ID</th>
                        <th scope="col"><%=request.getParameter("id")%></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Course Category</td>
                        <td id="cc"></td>
                    </tr>
                     <tr>
                        <td>Topic</td>
                        <td id="topic"></td>
                    </tr>
                     <tr>
                        <td>Trainer</td>
                        <td id="trainer"></td>
                    </tr>
                     <tr>
                        <td>Time</td>
                        <td id="time"></td>
                    </tr>
                     <tr>
                        <td>Schedule</td>
                        <td id="sche"></td>
                    </tr>
                     <tr>
                        <td>Room</td>
                        <td id="room"></td>
                    </tr>
                     <tr>
                        <td>Status</td>
                        <td id="stt"></td>
                    </tr>
                     <tr>
                        <td>Description</td>
                        <td id="des"></td>
                    </tr>
                     <tr>
                        <td>Content</td>
                        <td id="content"></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
