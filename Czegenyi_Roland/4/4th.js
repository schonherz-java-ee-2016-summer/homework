// JavaScript Document

$(document).on('click', 'div.square', function () {
    "use strict";
    var color = $(this).css('background-color');
    $('#square2').css("background-color", color);
});

//Alternative solution.
/*
$(document).ready(function () {
    "use strict";
    $(".square").click(function () {
        var color = $(this).css('background-color');
        $('#square2').css("background-color", color);
    });
});
 */