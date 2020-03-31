function scrollBar() {
  var bar = document.getElementById("myBar");
  var div = document.getElementsByClassName("lot-list-container")[0]
  var width = 1300 - div.offsetWidth;
  bar.style.width = (div.scrollLeft / width) * 100 + "%";
}
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


