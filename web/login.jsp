<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
    <div class="container">
    <img src="img/img-logo-fe.png">
    <h1>Login</h1>
    </div>
     ${error}
     <form action="LoginController" method="POST">
        <div class="form-group">
          <label for="Username">Username:</label> 
          <input type="text" class="form-control" placeholder="Enter Username" id="Username" name="txtUsn"/>
        </div>
        <div class="form-group">
          <label for="pwd">Password:</label>
          <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="txtPw">
        </div>
        <div style="text-align: center">
        <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"> Login</i></button>
    </div>
      </form>
    </div>
</body>
</html>