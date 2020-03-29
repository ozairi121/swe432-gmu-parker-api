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
</head>

<body>
<div class='header container p-0 w-100 m-0 sticky-top mw-none'>
    <div class='row py-2'>
        <div class='col-lg-2'>
            <img class='float-right pointer' height='40px' src='./gmu-logo.png' alt='George Mason University logo' />
        </div>
        <div class='col-lg-5 pt-2'>
            <h4 class='pointer'>GMU Parking Lot Reviewer</h4>
        </div>
        <div class='col-lg-4 pr-5 pt-1'>
            <button class='float-right mt-0 mr-5 btn btn-success' onclick='location.reload()'>
                New review +
            </button>
            <button class='float-right mt-0 mr-3 btn btn-success' onclick='location.reload()'>
                Reviews
            </button>
        </div>
    </div>
</div>

<div style="background: black; color: white">
    <h2 class='text-center py-3'>Welcome to the GMU Parking Lot Reviewer</h2>
    <p class='center w-25 py-2 pb-4'>This app is meant to let students write reviews for the parking lots on George Mason's Fairfax campus. We hope this can help other students know what to expect before they go to a certain parking lot.</p>
</div>


<strong>${params}</strong>

<div class='footer'>
</div>

</body>

<script>

  // Save the selected rating and lot DOMs to remove css classes when unselected
  let lastRating = lastLot = null;

  let newReview = {
    lot: 0,
    rating: 0,
  };

  // Set a rating for the lot
  function setLot(lot, name='Selected') {
    newReview.lot = name;
    let elements = $('.lot-list .col.d-inline');
    elements[lot-1].classList.add('active-lot');
    if (lastLot)
      lastLot.classList.remove('active-lot')
    lastLot = elements[lot-1];
    document.getElementById('selectedLot').innerHTML = name;
  }

  // Set a rating for the lot
  function setRating(rating) {
    newReview.rating = rating;
    let elements = $('.rating-list .col.d-inline');
    elements[rating-1].classList.add('active-rating');
    if (lastRating)
      lastRating.classList.remove('active-rating')
    lastRating = elements[rating-1];
    document.getElementById('selectedRating').innerHTML = rating;
  }

  // Checks the checkbox that was just selected and unchecks the rest
  $(document).ready(function(){
    $('input[type="checkbox"]').click(function(){
      const checkboxParent = this;

      $(`input[name="${checkboxParent.name}"]`).each(function(obj) {
        if (checkboxParent.value !== this.value)
          this.checked = false;
      })
    });
  });

  // Add the selected lot and lot rating to the form with jQuery
  // since a div tag does not have input attributes
  $("#parking-review-form").submit( function(eventObj) {
    $("<input />").attr('type', 'hidden')
      .attr('name', 'selectedLot')
      .attr('value', newReview.lot)
      .appendTo(this);
    $("<input />").attr('type', 'hidden')
      .attr('name', 'lotRating')
      .attr('value', newReview.rating)
      .appendTo(this);
    return true;
  });

</script>

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
    .lot-list.container {
        background: #efefef;
        color: green;
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
    input[type='checkbox'] {
        cursor: pointer;
    }
</style>

</html>

