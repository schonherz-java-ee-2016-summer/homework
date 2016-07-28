alertIfNotNumber = false;
function displayDialogIfEmpty() {
    var input;
    if (alertIfNotNumber) {
        alert("Age must be a number");
        return false;
    }
    for (var i = 0; i < arguments.length; i++) {
        input = $.trim($(arguments[i]).val());
        if (!input) {
            alert("Please fill in every fields.");
            return false;
        }
    }
}
function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}
function containsOnlyNumber(id) {
    var val = $(id).val();
    alertIfNotNumber = true;
    if (isNumeric(val)) {
        $('#interactive-label').css('visibility', 'hidden');
        alertIfNotNumber = false;
    }
    else {
        $('#interactive-label').css('visibility', 'visible');
        alertIfNotNumber = true;
    }
}
