<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <title>GMU Parking Lot Reviews and Ratings | George Mason University</title>
  <link rel="shortcut icon" href="./gmu-logo.png">
</head>

<body>

<div class='header container p-0 w-100 m-0 sticky-top mw-none'>
  <div class='row py-2'>
    <div class='col-lg-2' onclick="window.location = '/'">
      <img class='float-right pointer' height='40px' src='https://osf.io/static/img/institutions/shields-rounded-corners/gmu-shield-rounded-corners.png' alt='George Mason University logo' />
    </div>
    <div class='col-lg-5 pt-2' onclick="window.location = '/'">
      <h4 class='pointer'>GMU Parking Lot Reviewer</h4>
    </div>
    <div class='col-lg-4 pr-5 pt-1'>
      <button class='float-right mt-0 mr-3 btn btn-success' onclick='window.location = "/"'>
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

<style>
  body {
    margin: 0;
  }
  .header {
    background: gray;
    color: white;
  }
  .footer {
    height: 120px;

  }
  .lot-list-container {
    background: #efefef;
    color: green;
    overflow: scroll;
    width: 100%;
  }
  .lot-list-container::-webkit-scrollbar {
    display: none;
  }
  .rating-list {
    background: #efefef;
    color: white;
  }
  .active-lot {
    background: green;
    margin: -10px;
    padding-top: 10px;
    color: white !important;
  }
  .active-rating {
    background: yellow;
    margin: -10px;
    color: black;
    padding-top: 10px;
  }
  .center {
    margin: 0 auto !important;
  }
  .b-lightgray {
    background: #efefef;
  }
  .mw-none {
    max-width: none !important;
  }
  .col.d-inline {
    font-size: 17pt;
    color: green;
  }
  .col.d-inline:hover {
    background: #def310;
    color: green;
    margin: -10px;
    padding-top: 10px;
    cursor: pointer;
  }
  .component-shadow {
    box-shadow: 0 1px 6px #09a00e8c;
  }
  .side-shadow {
    box-shadow: 0 9px 0px 0px white, 0 -9px 0px 0px white, 12px 0 15px -4px #108619cc, -12px 0 15px -4px #108619cc;
  }
  .required:after {
    content:" *";
    color: red;
  }
  .pointer {
    cursor: pointer !important;
  }
  input[type='checkbox'] {
    cursor: pointer !important;
  }
  .progress-container {
    width: 100%;
    height: 8px;
    background: #ccc;
  }
  .progress-bar {
    height: 8px;
    background: #4caf50;
    width: 5%;
  }

</style>

</html>

