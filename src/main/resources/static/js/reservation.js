const today = new Date().toISOString().split("T")[0];

const tripTypes = document.querySelectorAll('input[name="tripType"]');
const tripTypeError = document.querySelector("#tripTypeError");

const departureCity = document.querySelector("#departureCity");
const departureCityError = document.querySelector("#departureCityError");

const arrivalCity = document.querySelector("#arrivalCity");
const arrivalCityError = document.querySelector("#arrivalCityError");

const sameCityErrors = document.querySelectorAll(".sameCityError");

const airline = document.querySelector("#airline");
const airlineError = document.querySelector("#airlineError");

const departureDate = document.querySelector("#departureDate");
const departureDateError = document.querySelector("#departureDateError");

const returnDate = document.querySelector("#returnDate");
const returnDateError = document.querySelector("#returnDateError");

const adultsCount = document.querySelector("#adultsCount");
const adultsCountError = document.querySelector("#adultsCountError");

const reviewBtn = document.querySelector("#review-btn");

// Clear Error
const clearErrors = (element, error, input = false) => {
  element.addEventListener(!input ? "change" : "input", () => {
    error.textContent = "";
    error.style.display = "none";
  });
};

// Clears trip type error message
tripTypes.forEach((tripType) => {
  tripType.addEventListener("change", () => {
    tripTypeError.textContent = "";
    tripTypeError.style.display = "none";
  });
});

// Clears departure city error message
clearErrors(departureCity, departureCityError);

// Clears arrival city error message
clearErrors(arrivalCity, arrivalCityError);

// Clears same city error message
const clearSameCityErrors = (element) => {
  element.addEventListener("change", () => {
    if (validateArrivalDepartureCityDistinct()) {
      sameCityErrors.forEach((sameCityError) => {
        sameCityError.textContent = "";
        sameCityError.style.display = "none";
      });
    }
  });
};
clearSameCityErrors(departureCity);
clearSameCityErrors(arrivalCity);

// Clears airline error message
clearErrors(airline, airlineError);

// Clears departure date error message
clearErrors(departureDate, departureDateError);

// Clears return date error message
clearErrors(returnDate, returnDateError);

// Clears adult count error message
clearErrors(adultsCount, adultsCountError, true);

//Validate
const validate = (element, errorElement, errorMessage = "This field") => {
  if (!element.value) {
    errorElement.textContent = `${errorMessage} is required`;
    errorElement.style.display = "block";
    element.scrollIntoView({ behavior: "smooth", block: "start" });
    return false;
  }
  return true;
};

//validates that the trip type is selected
const validateTripType = () => {
  const selectedTrip = document.querySelector('input[name="tripType"]:checked');
  if (selectedTrip == null) {
    tripTypeError.textContent = 'Please select either "Round Trip" or "One Way Trip"';
    tripTypeError.style.display = "block";

    tripTypeError.scrollIntoView({ behavior: "smooth", block: "start" });
    return false;
  }
  return true;
};

//validates that the arrival and departure cities are different
const validateArrivalDepartureCityDistinct = () => {
  if (departureCity.value && arrivalCity.value && departureCity.value == arrivalCity.value) {
    sameCityErrors[0].textContent = "Must be different from arrival city";
    sameCityErrors[0].style.display = "block";
    sameCityErrors[1].textContent = "Must be different from departure city";
    sameCityErrors[1].style.display = "block";
    sameCityErrors[0].scrollIntoView({ behavior: "smooth", block: "start" });
    return false;
  }
  return true;
};

//Disables return date field if one way trip is selected
tripTypes.forEach((tripType) => {
  tripType.addEventListener("change", () => {
    returnDate.disabled = false;
    returnDate.style.background = "";
    returnDate.style.border = "";


    const selectedTrip = document.querySelector('input[name="tripType"]:checked');

    if (selectedTrip.value == "One Way Trip") {
      returnDate.disabled = true;
      returnDate.style.background = "lightgray";
      returnDate.style.border = "lightgray";
      returnDateError.textContent = "";
      returnDateError.style.display = "none";
    }
  });
});

//validates that the return date is entered
const validateReturnDate = () => {
  if (!returnDate.value && !returnDate.disabled) {
    returnDateError.textContent = "Return date is required";
    returnDateError.style.display = "block";
    returnDateError.scrollIntoView({ behavior: "smooth", block: "start" });
    return false;
  }
  return true;
};

//Ensures that user can only select today's date or futures date for departure and return date
departureDate.min = today;
returnDate.min = today;

//Ensures return date is always greater than or equal to departure date
departureDate.addEventListener("change", () => {
  returnDate.min = departureDate.value;
  returnDate.value = "";
});

// This prevents the user to enter value less than 1 as adult count
adultsCount.addEventListener("input", () => {
  if (adultsCount.value < 1) adultsCount.value = "";
});

reviewBtn.addEventListener("click", (event) => {
  event.preventDefault();

  let isValid = true;

  if (!validateTripType()) isValid = false;

  //validates that the departure city is selected
  if (!validate(departureCity, departureCityError, "Departure city")) isValid = false;

  //validates that the arrival city is selected
  if (!validate(arrivalCity, arrivalCityError, "Arrival city")) isValid = false;

  if (!validateArrivalDepartureCityDistinct()) isValid = false;

  //validates that the airline is selected
  if (!validate(airline, airlineError, "Airline")) isValid = false;

  //validates that the departure date is entered
  if (!validate(departureDate, departureDateError, "Departure date")) isValid = false;

  if (!validateReturnDate()) isValid = false;

  //validates that the adult count is entered
  if (!validate(adultsCount, adultsCountError)) isValid = false;

  if (isValid) {
    console.log("Submitted");

    document.querySelector("#reservation-form").submit();
  }
});
