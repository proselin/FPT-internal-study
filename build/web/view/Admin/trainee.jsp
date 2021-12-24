<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="../../css/Admin/trainee.css">
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
        <title>Trainee Management</title>
        <script>
            $(document).ready(function () {
                $("#add-new").hide();
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
                $("#addTrainee").click(function () {
                    $("#show").hide();
                    $("#add-new").show();
                    $("#add-search").hide();
                });
                $(function () {
                    $("#birthdaytime").datepicker();
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
        <div id="add-search">
            <div class="add">
                <button id="addTrainee" class="button"><span>Add new trainee </span></button>
            </div>
            <div class="search">
                <form>
                    <input type="text" name="search" placeholder="Search trainee..." id="myInput">
                </form> 
            </div>
        </div>
        <br>
        <br>
        <br>
        <div id="show" >
            <div class="container">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Date of Birth</th>
                            <th>Username</th>
                            <th>Password</th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
                        <c:if test="${empty requestScope['listT']}">
                            <jsp:forward page = "/TraineController?ac=view" />
                        </c:if>
                        <c:forEach items="${listT}" var = "x" >
                            <tr>
                                <td>${x.getUserID()}</td>
                                <td>${x.getFullName()}</td>
                                <td>${x.getAddress()}</td>
                                <td>${x.getPhone()}</td>
                                <td>${x.getEmail()}</td>
                                <td>${x.getDate_Of_Birth()}</td>
                                <td>${x.getUsername()}</td>
                                <td>${x.getPassword()}</td>
                                <td><a href="../../TraineController?ac=getid&id=${x.getUserID()}">Update</a></td>
                                <td><a href="../../TraineController?ac=del&id=${x.getUserID()}" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div id="add-new">
            ${error}
            <form action="../../TraineController?ac=add" method="POST">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id" required>
                </div>
                <div class="form-group">
                    <label for="fname">FullName:</label>
                    <input type="text" class="form-control" id="fname" placeholder="Enter FullName" name="fname" required>
                </div>
                <div class="form-group">
                    <label for="add">Address</label>
                    <input type="text" class="form-control" id="add" placeholder="Enter Address" name="add" required>
                </div>
                <div class="form-group">
                    <label for="phone">Phone</label>
                    <input type="text" class="form-control" id="phone" placeholder="Enter Phone" name="phone" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter UserName" name="uname" required>
                </div>
                `<div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="text" class="form-control" id="pass" placeholder="Enter Password" name="pass" required>
                </div>
                <label for="birthdaytime">Birthday (date and time):</label>
                <input type="text" id="birthdaytime" name="birthdaytime"><br>
                <input type="submit" value="add" >
            </form>
        </div>
    </body>
</html>