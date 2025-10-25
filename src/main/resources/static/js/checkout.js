const cardTypeInput = document.querySelectorAll("input[name='card-type']");
const cardTypeInputError = document.querySelector("#card-type-error");

const cardHolderInput = document.querySelector("#card-holder");
const cardHolderInputError = document.querySelector("#card-holder-error");

const cardNumberInput = document.querySelector("#card-number");
const cardNumberInputError = document.querySelector("#card-number-error");

const expiryDateInput = document.querySelector("#expiry-date");
const expiryDateInputError = document.querySelector("#expiry-date-error");

const cvcCodeInput = document.querySelector("#cvc-code");
const cvcCodeInputError = document.querySelector("#cvc-code-error");

const proceedBtn = document.querySelector("#proceed-btn");

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

const validateCardType = () => {
  const selectedCardType = document.querySelector("input[name='card-type']:checked");
  if(selectedCardType == null) {
    cardTypeInputError.textContent = "Please select the card type";
    cardTypeInputError.style.display = "block";
    return false;
  }
  return true
};

cardTypeInput.forEach((type) => {
  type.addEventListener("change", () => {
    cardTypeInputError.textContent = "";
    cardTypeInputError.style.display = "";
  });
});

removeError(cardHolderInput, cardHolderInputError);
removeError(cardNumberInput, cardNumberInputError);
removeError(expiryDateInput, expiryDateInputError);
removeError(cvcCodeInput, cvcCodeInputError);

const today = new Date().toISOString().split("T")[0];
expiryDateInput.min = today;

proceedBtn.addEventListener("click", (e) => {
  e.preventDefault();
  var isValid = true;
  if (!validateCardType()) isValid = false;
  if (setError(cardHolderInput, cardHolderInputError, "Card holder is required")) isValid = false;
  if (setError(cardNumberInput, cardNumberInputError, "Card number is required")) isValid = false;
  if (setError(expiryDateInput, expiryDateInputError, "Expiry date is required")) isValid = false;
  if (setError(cvcCodeInput, cvcCodeInputError, "CVC code is required")) isValid = false;

  if (isValid) {
    document.querySelector("#payment-form").submit();
  }
});
