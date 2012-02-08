function checkForEmptyFields() {

    var form = document.getElementById("form");
    var errors = new Array();
    var errorIndex = 0;

    for (var i = 0; i < form.length - 1; i++) {
        if (form.elements[i].value.length == 0) {
            errors[errorIndex] = "Please enter your: " + form.elements[i].name + "\n";
            errorIndex++;
        }
    }

    if (errors.length > 0) {
        alert(errors);
    }
}

function checkFirstNameLength() {

    if (document.getElementById('firstName').value.length < 1) {
        alert("First Name must contain at least one character");
    }
}

function checkLastNameLength() {

    if (document.getElementById('lastName').value.length < 1) {
        alert("Last Name must contain at least one character")
    }
}

function isEgnValid() {

    if (isNaN(document.getElementById('egn').value) || document.getElementById('egn').value.length < 10) {
        alert("EGN must contain only digits and must be 10 characters long");
    }
}

function isAgeValid() {

    if (document.getElementById('age').value < 18 || document.getElementById('age').value > 118) {
        alert("Age must be between 18 and 118 years");
    }
}

function checkAddressLength() {

    if (document.getElementById('address').value.length < 10) {
        alert("Address must contain at least 10 characters")
    }
}

function isPasswordValid() {

    var pass = /^[A-Za-z0-9]{6,20}$/;

    if (!pass.test(document.getElementById('password').value)) {
        alert("Password must contain only characters and numbers");
    }
}

function comparePasswords() {

    if (!(document.getElementById('password').value === document.getElementById('confirmPassword').value)) {
        alert("The passwords don't match");
    }
}