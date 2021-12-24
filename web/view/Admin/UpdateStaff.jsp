<%-- 
    Document   : UpdateTrainee
    Created on : 20-08-2021, 09:26:54
    Author     : mangn
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="../../css/Admin/staff.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <title>JSP Page</title>
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
                        <li class="nav-item" style="background-color: rgb(119, 163, 204);">
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
                        <li class="nav-item">
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
        <br>
        <br>
        <h1 style="text-align: center">Update Staff</h1>
        <div id="add-new">
            ${error}
            <c:set var="x" value="${requestScope['data']}"/>
            <form action="StaffController?ac=doUpdate" method="POST">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" class="form-control" id="id" value="${x.getUserID()}" name="id" readonly="true" >
                </div>
                <div class="form-group">
                    <label for="fname">FullName:</label>
                    <input type="text" class="form-control" id="fname" value="${x.getFullName()}" name="fname" >
                </div>
                <div class="form-group">
                    <label for="add">Address</label>
                    <input type="text" class="form-control" id="add" value="${x.getAddress()}" name="add" >
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" value="${x.getPhone()}" name="phone" >
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" value="${x.getEmail()}" name="email" >
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="uname" value="${x.getUsername()}" name="uname" >
                </div>
                `<div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="text" class="form-control" id="pass" value="${x.getPassword()}" name="pass" >
                </div>
                <label for="birthdaytime">Birthday (date and time):</label>
                <input type="text" id="birthdaytime" name="birthdaytime" value="${x.getDate_Of_Birth()}"><br>
                <input type="submit" value="update" >
            </form>
        </div>
    </body>
</html>
