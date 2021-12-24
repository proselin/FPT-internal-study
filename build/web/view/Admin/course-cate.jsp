<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="../../css/Admin/course-cate.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Course Category Management</title>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
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
                        <li class="nav-item" style="background-color: rgb(119, 163, 204);">
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
        <div class="search">
            <form>
                <input type="text" name="search" placeholder="Search course category..." id="myInput">
            </form> 
        </div>
        <br>
        <br>
        <div class="container-fluit">
            <div class="col-md-4" style="float: left;">
                <form action="../../CourseCateController?ac=add" method="POST">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
                    </div>
                    <div class="form-group">
                        <label for="id">Name:</label>
                        <input type="text" class="form-control" id="id" placeholder="Enter name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="description">Description:</label>
                        <textarea class="form-control" rows="5" id="description" name="description" required placeholder="Enter Description"></textarea>
                    </div>
                    <br>
                    <input type="file" class="form-control-file border" name="file">
                    <br>
                    <input type="submit" class="btn btn-success" value="Add">
                </form>
            </div>
            <div class="col-md-6" style="float: left;">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Logo</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
                        <c:if test="${empty requestScope['listCC']}">
                            <jsp:forward page = "/CourseCateController?ac=view" />
                        </c:if>
                        <c:forEach items="${listCC}" var = "x" >
                            <tr>
                                <td>${x.getCousre_cate_ID()}</td>
                                <td>${x.getCourse_cate_Name()}</td>
                                <td>${x.getCourse_Cate_Des()}</td>
                                <td>${x.getCourse_Cate_Img()}</td>
                                <td><a href="../../CourseCateController?ac=getid&id=${x.getCousre_cate_ID()}">Update</a></td>
                                <td><a href="../../CourseCateController?ac=del&id=${x.getCousre_cate_ID()}" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>