function displayDialogIfEmpty() {
    var input;
    for (var i = 0; i < arguments.length; i++) {
        input = $.trim($(arguments[i]).val());
        if (!input) {
            alert("Please fill in every fields.");
            return false;
        }
    }
}
