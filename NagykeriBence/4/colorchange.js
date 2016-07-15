function toColor(id) {
	var colorByID = $(id).css('background-color');
	$('#black-square').css('background-color', colorByID);
}