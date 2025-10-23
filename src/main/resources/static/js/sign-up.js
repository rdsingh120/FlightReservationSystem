const firstNameInput = document.querySelector("#first-name");
const firstNameInputError = document.querySelector("#first-name-error");

const lastNameInput = document.querySelector("#last-name");
const lastNameInputError = document.querySelector("#last-name-error");

const emailInput = document.querySelector("#email");
const emailInputError = document.querySelector("#email-error");

const passwordInput = document.querySelector("#password");
const passwordInputError = document.querySelector("#password-error");

const confirmPasswordInput = document.querySelector("#confirm-password");
const confirmPasswordInputError = document.querySelector("#confirm-password-error");

const signUpBtn = document.querySelector("#sign-up-btn");

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

const emailValidation = () => {
  const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  emailInputError.textContent = "";
  emailInputError.style.display = "none";
  if (!emailInput.value.match(emailRegex)) {
    emailInputError.textContent = "Email is not valid";
    emailInputError.style.display = "block";
    return false;
  }
  return true;
};

const passwordConfirmation = () => {
  confirmPasswordInputError.textContent = "";
  confirmPasswordInputError.style.display = "none";
  if (passwordInput.value != confirmPasswordInput.value) {
    confirmPasswordInputError.textContent = "Password doesn't match";
    confirmPasswordInputError.style.display = "block";
    return false;
  }
  return true;
};

removeError(firstNameInput, firstNameInputError);
removeError(lastNameInput, lastNameInputError);
removeError(emailInput, emailInputError);
removeError(passwordInput, passwordInputError);
removeError(confirmPasswordInput, confirmPasswordInputError);

emailInput.addEventListener("input", emailValidation);

passwordInput.addEventListener("input", passwordConfirmation);
confirmPasswordInput.addEventListener("input", passwordConfirmation);

signUpBtn.addEventListener("click", (e) => {
  e.preventDefault();
  var isValid = true;
  if (!emailValidation()) isValid = false;
  if (!passwordConfirmation()) isValid = false;
  if (setError(firstNameInput, firstNameInputError, "First name is required")) isValid = false;
  if (setError(lastNameInput, lastNameInputError, "Last name is required")) isValid = false;
  if (setError(emailInput, emailInputError, "Email is required")) isValid = false;
  if (setError(passwordInput, passwordInputError, "Password is required")) isValid = false;
  if (setError(confirmPasswordInput, confirmPasswordInputError, "Confirm password is required")) isValid = false;

  if (isValid) {
    document.querySelector("#sign-up-form").submit();
  }
});
