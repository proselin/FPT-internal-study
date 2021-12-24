<%-- 
    Document   : ListStudentofCuurse
    Created on : 24-08-2021, 10:04:36
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
                var v = $("#getid").text()
                console.log(v)
                $.ajax({
                    url: "../../CourseController?ac=viewTrainee",
                    method: "POST",
                    data: {getid: v},
                    success: function (data) {
                        console.log(data);
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            $('#myTable').append("<tr> \n\
                    <td> " +value.UserID+"</td> \n\
                     <td> " +value.FullName+"</td> \n\
                      <td> " +value.Email+"</td> \n\
                       <td> " +value.Phone+"</td> \n\
                        <td> " +value.Address+"</td> \n\
                        <td> " +"<a href = "+"../../CourseController?id="+value.UserID+">Delete</a>"+"</td> \n\
                    <tr>")
                        });
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
        <h1 id="getid" style="display: none"><%=request.getParameter("id")%></h1>
        <h2 style="text-align: center">Student list of Course <%=request.getParameter("id")%></h2>
        <br>
         <div class="view-add">
            <ul class="nav nav-pills">
                <li>
                    <button type="button" class="btn btn-primary" id="view"><h5 id="h5">View</h5></button>
                </li>
                <li>
                    <button type="button" class="btn btn-light" id="add"><a href="AddStudentToCourse.jsp?id=<%=request.getParameter("id")%>"><h5>Add</h5></a></button>
                </li>
            </ul>
        </div>
        <div id ="show">
            <div class="search" style="margin-bottom: 10px">
                <form>
                    <input type="text" name="search" placeholder="Search student..." id="myInput">
                </form> 
            </div>    
            <div class="container">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>FullName</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
                    </tbody>
                </table>
            </div>
    </body>
</html>
