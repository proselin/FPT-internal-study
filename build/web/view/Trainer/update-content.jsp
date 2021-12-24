<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../css/Trainer/update-content.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
        integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Home page</title>
</head>

<body>
    <img src="../../img/img-logo-fe.png">
    <div class="container-fluit" style="margin-left: 130px;width: 950px;">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="home.html"><i class="fas fa-home"> Home</i></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="course.html"><i class="fas fa-box"> Course Management</i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="account.html"><i class="fas fa-file-contract"> Account
                                Management</i></a>
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
    <h1 style="text-align: center;">Content</h1>
    <div class="container" style="margin-left: 35%;">
        <form action="">
            <div class="form-group">
                <textarea class="form-control" rows="5" id="description" name="description"
                    placeholder="Enter Description"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>

</html>