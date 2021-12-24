<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/Staff/course-cate.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Course Category Management</title>
    <script>
        $(document).ready(function(){
          $("#myInput").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
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
        <a class="navbar-brand" href="index.html"><i class="fas fa-home"> Home</i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item" style="background-color: rgb(119, 163, 204);">
                <a class="nav-link" href="course-cate.html"><i class="fas fa-box"> Course category Management</i></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="topic.html"><i class="fas fa-file-contract"> Topic Management</i></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="course.html"><i class="fas fa-book-reader"> Course Management</i></a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="course.html"><i class="fas fa-sign-out-alt"> Log out</i></a>
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
            <form action="" class="was-validated">
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter username" name="uname" required>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                  </div>
                  <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" rows="5" id="description" name="description" required placeholder="Enter Description"></textarea>
                    <div class="valid-feedback">Valid.</div>
                    <div class="invalid-feedback">Please fill out this field.</div>
                  </div>
                  <br>
                    <input type="file" class="form-control-file border">
                    <br>
                  <button type="button" class="btn btn-success">Success</button>
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
                    <th>Trainer</th>
                    <th>Update</th>
                    <th>Delete</th>
                  </tr>
                </thead>
                <tbody id="myTable">
                </tbody>
              </table>
        </div>
    </div>
</body>
</html>