<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>GMU Parking Lot Reviews and Ratings | George Mason University</title>
    <link rel="shortcut icon" href="./gmu-logo.png">
    <link href="./style.css" rel="stylesheet">
</head>

<body>
<div class='header container p-0 w-100 m-0 sticky-top mw-none'>
    <div class='row py-2'>
        <div class='col-lg-2' onclick="window.location = '/'">
            <img class='float-right pointer' height='40px' src='./gmu-logo.png' alt='George Mason University logo' />
        </div>
        <div class='col-lg-5 pt-2' onclick="window.location = '/'">
            <h4 class='pointer'>GMU Parking Lot Reviewer</h4>
        </div>
        <div class='col-lg-4 pr-5 pt-1'>
            <button class='float-right mt-0 mr-3 btn btn-success' onclick='location.reload()'>
                New review +
            </button>
        </div>
    </div>
</div>

<div class="mt-3">
    <div class="alert alert-success w-75 center" role="alert">
        <h2>
            Thank you for submitting your review!
        </h2>
    </div>
</div>


<div class="mt-5">${params}</div>


<div class='m-5 text-center'>
    <button class='w-75 btn btn-success' onclick='window.location = "/"'>
        <h4>Submit another review</h4>
    </button>
</div>

<div class='footer'>
</div>

</body>

</html>

