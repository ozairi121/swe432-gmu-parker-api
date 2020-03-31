<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>

<!DOCTYPE html>

<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <title>GMU Parking Lot Reviews and Ratings | George Mason University</title>
  <link href="./gmu-logo.png" rel="shortcut icon">
</head>

<body>
  <div class='header container p-0 w-100 m-0 sticky-top mw-none'>
    <div class='row py-2'>
      <div class='col-lg-2' onclick="window.location = '/'">
        <img class='float-right pointer' height='40px' src='/gmu-logo.png' alt='George Mason University logo' />
      </div>
      <div class='col-lg-5 pt-2' onclick="window.location = '/'">
        <h4 class='pointer'>
          GMU Parking Lot Reviewer
          <small class="ml-4">
            Author: Omar Zairi
          </small>
        </h4>
      </div>
      <div class='col-lg-4 pr-5 pt-1'>
        <button class='float-right mt-0 mr-3 btn btn-success' onclick='window.location = "/"'>
          New review +
        </button>
      </div>
    </div>
  </div>

  <div id="masthead" style="background: black; color: white">
    <p class='center w-50 py-3 pb-2'>This app is meant to let students write reviews for the parking lots on George Mason's Fairfax campus. We hope this can help other students know what to expect before they go to a certain parking lot.</p>
  </div>

  <form id='parking-review-form' action="https://gmu-parking-reviewer.herokuapp.com/review" method="post" class='side-shadow w-75 center border-right border-left px-5 pb-5 mb-5'>

    <div class="mt-2 pt-3">
      <div class="alert alert-danger d-none" role="alert" id="form-error">
        Sorry, please finish answering the required fields
      </div>
    </div>

    <h6 class='pt-5'>
          <span class='ml-5 border rounded p-2 text-danger'>
              <strong>1</strong>
          </span>
      <strong class='ml-5 required'>Pick a parking lot</strong>
      <span class='component-shadow float-right mr-5 alert-secondary py-1 px-3'>
              <h5 class='mt-2 border rounded text-primary'>
                  <b id='selectedLot'>-</b>
              </h5>
          </span>
    </h6>

    <div class="lot-list-container mt-5" onscroll="scrollBar()">
      <div class='lot-list text-center' id='lot-list'>
        <div class='row p-2'>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(1, "Lot A")'>
            Lot A
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(2, "Lot C")'>
            Lot C
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(3, "Lot I")'>
            Lot I
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(4, "Lot J")'>
            Lot J
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(5, "Lot K")'>
            Lot K
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(6, "Lot L")'>
            Lot L
          </div>
          <div class='col d-inline text-nowrap px-3' onclick='setLot(7, "Lot R")'>
            Lot R
          </div>
          <div class='col d-inline text-nowrap px-4' onclick='setLot(8, "PV Lot")'>
            PV Lot
          </div>
          <div class='col d-inline text-nowrap px-4' onclick='setLot(9, "Shenandoah")'>
            Shenandoah
          </div>
          <div class='col d-inline text-nowrap px-4' onclick='setLot(10, "Rappahannock River")'>
            Rappahannock River
          </div>
        </div>
      </div>
    </div>
    <div class="progress-container">
      <div class="progress-bar" id="myBar"></div>
    </div>

    <h6 class='m-2 mt-5 pt-5'>
          <span class='ml-5 border rounded p-2 text-danger'>
              <strong>2</strong>
          </span>
      <strong class='ml-5 required'>
        How many stars would you give the parking lot?
      </strong>
      <small>
        <strong class='text-muted ml-3'>
          5 = good, 1 = bad
        </strong>
      </small>
      <span class='component-shadow float-right mr-5 alert-secondary py-1 px-3'>
              <h5 class='mt-2 border rounded text-primary'>
                  <b id='selectedRating'>-</b>
              </h5>
          </span>
    </h6>

    <div class='container rating-list mt-5 text-center'>
      <div class='row'>
        <div class='col d-inline' onclick='setRating(1)'>
          1
        </div>
        <div class='col d-inline' onclick='setRating(2)'>
          2
        </div>
        <div class='col d-inline' onclick='setRating(3)'>
          3
        </div>
        <div class='col d-inline' onclick='setRating(4)'>
          4
        </div>
        <div class='col d-inline' onclick='setRating(5)'>
          5
        </div>
      </div>
    </div>

    <h6 class='m-2 mt-5 pt-5'>
          <span class='ml-5 border rounded p-2 text-danger'>
              <strong>3</strong>
          </span>
      <strong class='ml-5'>Please give your opinion on the following questions</strong>
    </h6>

    <div class='container'>
      <div class='mt-2 row border-bottom py-3'>
        <div class='col required'>
          Is it hard to find a spot in the morning?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="morningTraffic" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="morningTraffic" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="morningTraffic" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="morningTraffic" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
      <div class='mt-2 row border-bottom py-3'>
        <div class='col required'>
          Is it hard to find a spot in the afternoon?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="afternoonTraffic" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="afternoonTraffic" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="afternoonTraffic" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="afternoonTraffic" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
      <div class='mt-2 row border-bottom py-3'>
        <div class='col required'>
          Is it hard to find a spot in the evening?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="eveningTraffic" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="eveningTraffic" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="eveningTraffic" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="eveningTraffic" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
      <div class='mt-2 row border-bottom py-3'>
        <div class='col required'>
          Are the parking spots big enough?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="parkingSize" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="parkingSize" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="parkingSize" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="parkingSize" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
      <div class='mt-2 row border-bottom py-3'>
        <div class='col-lg-5 required'>
          How convenient is to Eagle Bank Arena?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="arenaConvenience" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="arenaConvenience" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="arenaConvenience" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="arenaConvenience" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
      <div class='mt-2 row py-3'>
        <div class='col-lg-5 required'>
          How convenient is to a gym?
        </div>
        <div class='col-lg-7'>
          <div class='row'>
            <div class='col-lg-2'>
              <input type="checkbox" name="gymConvenience" value="Very">
              <b>Very</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="gymConvenience" value="Kinda">
              <b>Kinda</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="gymConvenience" value="Not really">
              <b>Not Really</b>
            </div>
            <div class='col-lg-3'>
              <input type="checkbox" name="gymConvenience" value="Not sure">
              <b>Not sure</b>
            </div>
          </div>
        </div>
      </div>
    </div>


    <div class='m-2 text-center mt-5 pt-4'>
      <input type="submit" class='btn btn-danger w-50 font-weight-bold'>
    </div>

  </form>

  <div class='footer w-100 text-center mt-2'>
  </div>

</body>

<script>

  // Save the selected rating and lot DOMs to remove css classes when unselected
  let lastRating = lastLot = null;

  let newReview = {
    lot: null,
    rating: null,
    morningTraffic: null,
    afternoonTraffic: null,
    eveningTraffic: null,
    parkingSize: null,
    arenaConvenience: null,
    gymConvenience: null,
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
      $(`input[name="`+checkboxParent.name+`"]`).each(function(obj) {
        newReview[checkboxParent.name] = true
        if (checkboxParent.value !== this.value)
          this.checked = false;
      })
    });
  });

  // Add the selected lot and lot rating to the form with jQuery
  // since a div tag does not have input attributes
  $("#parking-review-form").submit( function(eventObj) {
    // validate form
    if (!newReview.lot || !newReview.rating || !newReview.morningTraffic || !newReview.afternoonTraffic || !newReview.eveningTraffic || !newReview.parkingSize || !newReview.arenaConvenience || !newReview.gymConvenience) {
      $("#form-error").removeClass('d-none')
      document.getElementById("masthead").scrollIntoView( {behavior: "smooth" })
      return false;
    }
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

  function scrollBar() {
    var bar = document.getElementById("myBar");
    var div = document.getElementsByClassName("lot-list-container")[0]
    var width = 1300 - div.offsetWidth;
    var scrollPct = (div.scrollLeft / width) * 100;
    if (scrollPct < 5)
      bar.style.width = "5%";
    else
      bar.style.width = scrollPct + "%";
  }



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
  .lot-list,
  .lot-list .row {
    width: 1300px;
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
