<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/Trainee/account.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Home page</title>
    <script>
        $(document).ready(function(){
            $("#button-update").hide();
            $("#button-cancle").hide();
        $("#button-edit").click(function(){
            $("#button-update").show();
            $('input').removeAttr('readonly')
            $("#button-cancle").show();
            $("#button-edit").hide();
        });
        $("#button-cancle").click(function(){
            $("#button-update").hide();
            $("#button-cancle").hide();
            $("#button-edit").show();
            $('input').attr('readonly', true);
        });
});
    </script>
</head>
<body>
    <img src="../../img/img-logo-fe.png">
    <div class="container-fluit" style="margin-left: 130px;width: 950px;">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <a class="navbar-brand" href="home.html"><i class="fas fa-home"> Home</i></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                  <a class="nav-link" href="course.html"><i class="fas fa-box"> Course Management</i></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="account.html"><i class="fas fa-file-contract"> Account Management</i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout.html"><i class="fas fa-sign-out-alt"> Log out</i></a>
                  </li>
            </ul>
          </div>
        </nav>
  </div>
    <br>
    <br>
<div class="container">
    <div class="col-md-3" style="float: left; margin-right: 10px;">
        <img src="..." class="rounded float-left" alt="...">
    </div>
    <div class="col-md-7" style="float: left;" >
        <h2 style="text-align: center;">Information Management</h2>
       <div style="margin-left: 140px;">
        <form action="a.html" method="POST">
            <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <div class="form-group">
                <label for="uname">Username:</label>
                <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" readonly>
              </div>
              <label for="birthdaytime">Birthday (date and time):</label>
      <input type="datetime-local" id="birthdaytime" name="birthdaytime" readonly><br>
      <button type="submit" class="btn btn-primary" readonly id="button-update">Submit</button>
        </form>
       </div>
    </div>
    <div style="float: left">
        <button type="button" class="btn btn-warning" id="button-edit"><i class="fas fa-edit"></i>  Edit</button>
        <button type="button" class="btn btn-danger" id="button-cancle"><i class="far fa-window-close"></i> Cancle</button>
    </div>
</div>
</body>
</html>