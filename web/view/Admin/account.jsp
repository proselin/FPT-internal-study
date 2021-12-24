<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/Admin/account.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Account Management</title>
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
              <li class="nav-item">
                <a class="nav-link" href="course.jsp"><i class="fas fa-book-reader"> Course</i></a>
              </li>
              <li class="nav-item dropdown" style="background-color: rgb(119, 163, 204);">
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
    <h1>Update Account</h1>
    <br>
    <br>
    <div class="container">
      <form action="">
        <div class="form-update">
            <label for="pwd">Password:</label>
            <input type="text" placeholder="Password" id="pwd">
        </div>
        <br>
        <br>
        <button type="submit" class="btn btn-primary" style="margin-left: 50%;">Update</button>
      </form>
    </div>
</body>
</html>