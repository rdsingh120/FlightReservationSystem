const emailInput = document.querySelector("#email");
const emailInputError = document.querySelector("#email-error");

const passwordInput = document.querySelector("#password");
const passwordInputError = document.querySelector("#password-error");

const signInBtn = document.querySelector("#sign-in-btn");

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

removeError(emailInput, emailInputError);
removeError(passwordInput, passwordInputError);

emailInput.addEventListener("input", emailValidation);

signInBtn.addEventListener("click", (e) => {
  e.preventDefault();
  var isValid = true;
  if (!emailValidation()) isValid = false;
  if (setError(emailInput, emailInputError, "Email is required")) isValid = false;
  if (setError(passwordInput, passwordInputError, "Password is required")) isValid = false;

  if (isValid) {
    document.querySelector("#sign-in-form").submit();
  }
});
