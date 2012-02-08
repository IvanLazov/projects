var operationSet = false;
var equalSet = false;

function writeNumber(number) {

    var inputField = document.getElementById('input');

    if (equalSet) {
        inputField.value = "";
        equalSet = false;
    }

    inputField.value += number;
}

function operation(operator) {

    var inputField = document.getElementById('input');
    operationSet = true;
    equalSet = false;
    if("*/+-".indexOf(inputField.value.substr(inputField.value.length-1)) == -1){
        inputField.value += operator;
    }
}

function calculate() {

    var inputField = document.getElementById('input');
    inputField.value = eval(inputField.value);
    operationSet = false;
    equalSet = true;
}

function deleteLastDigit() {

    if (symbolOperation() == "+" || "-" || "*" || "/") {
        operationSet = true;
    }

    var inputField = document.getElementById('input');
    inputField.value = inputField.value.substr(0, inputField.value.length - 1);
}

function symbolOperation() {

    var inputField = document.getElementById('input');
    return inputField.value.substr(inputField.value.length - 1, inputField.value.length);
}

function clearInput() {

    document.getElementById('input').value = '';
    operationSet = false;
    equalSet = false;
}
