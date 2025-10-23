const today = new Date().toISOString().split("T")[0];

const nationalityInput = document.querySelector("#nationality");
const nationalityInputError = document.querySelector("#nationality-error");

const passportNumberInput = document.querySelector("#passport-number");
const passportNumberInputError = document.querySelector("#passport-number-error");

const issueDateInput = document.querySelector("#issue-date");
const issueDateInputError = document.querySelector("#issue-date-error");

const expiryDateInput = document.querySelector("#expiry-date");
const expiryDateInputError = document.querySelector("#expiry-date-error");

const phoneNumberInput = document.querySelector("#phone-number");
const phoneNumberInputError = document.querySelector("#phone-number-error");

const streetAddressInput = document.querySelector("#street-address");
const streetAddressInputError = document.querySelector("#street-address-error");

const cityInput = document.querySelector("#city");
const cityInputError = document.querySelector("#city-error");

const provinceInput = document.querySelector("#province");
const provinceInputError = document.querySelector("#province-error");

const postalCodeInput = document.querySelector("#postal-code");
const postalCodeInputError = document.querySelector("#postal-code-error");

const countryInput = document.querySelector("#country");
const countryInputError = document.querySelector("#country-error");

const signUpBtn = document.querySelector("#save-changes-btn");

const setError = (input, inputError, errorMessage) => {
  if (!input.value) {
    inputError.textContent = errorMessage;
    inputError.style.display = "block";
    return true;
  }
  return false;
};

const removeError = (input, inputError) => {
  input.addEventListener("input", () => {
    inputError.textContent = "";
    inputError.style.display = "none";
  });
};

removeError(nationalityInput, nationalityInputError);
removeError(passportNumberInput, passportNumberInputError);
removeError(issueDateInput, issueDateInputError);
removeError(expiryDateInput, expiryDateInputError);
removeError(phoneNumberInput, phoneNumberInputError);
removeError(streetAddressInput, streetAddressInputError);
removeError(cityInput, cityInputError);
removeError(provinceInput, provinceInputError);
removeError(postalCodeInput, postalCodeInputError);
removeError(countryInput, countryInputError);

issueDateInput.max = today
expiryDateInput.min = today

signUpBtn.addEventListener("click", (e) => {
  e.preventDefault();
  var isValid = true;
  if (setError(nationalityInput, nationalityInputError, "Nationality is required")) isValid = false;
  if (setError(passportNumberInput, passportNumberInputError, "Passport Number is required")) isValid = false;
  if (setError(issueDateInput, issueDateInputError, "Issue Date is required")) isValid = false;
  if (setError(expiryDateInput, expiryDateInputError, "Expiry Date is required")) isValid = false;
  if (setError(phoneNumberInput, phoneNumberInputError, "Phone Number is required")) isValid = false;
  if (setError(streetAddressInput, streetAddressInputError, "Street Address is required")) isValid = false;
  if (setError(cityInput, cityInputError, "City is required")) isValid = false;
  if (setError(provinceInput, provinceInputError, "Province/State is required")) isValid = false;
  if (setError(postalCodeInput, postalCodeInputError, "Postal/Zip Code is required")) isValid = false;
  if (setError(countryInput, countryInputError, "Country is required")) isValid = false;

  if (isValid) {
    document.querySelector("#complete-profile-form").submit();
  }
});
