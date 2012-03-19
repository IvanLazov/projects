function writeNumber(number) {

    document.getElementById('input').value += number;
}

function deleteLastDigit() {

    var input = document.getElementById('input');
    input.value = input.value.substr(0, input.value.length - 1);
}

function operation(operator) {

    var input = document.getElementById('input');
    if (input.value.length != 0 && isFinite(input.value)) {
        input.value += operator;
    }
}

function clearInput() {

    document.getElementById('input').value = "";
}