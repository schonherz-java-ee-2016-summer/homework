function blueColor() {
    document.getElementById("bigsquare").style.backgroundColor = "rgb(93, 208, 255)";
}

function redColor() {
    document.getElementById("bigsquare").style.backgroundColor = "red";
}

function greenColor() {
    document.getElementById("bigsquare").style.backgroundColor = "green";
}

function changeColor(id){
	var element = document.getElementById(id);
	var elementStyle = getComputedStyle(element);
	var bgcolor = elementStyle.backgroundColor;
	
	document.getElementById('bigsquare').style.backgroundColor = bgcolor;
}

function changeColor2(id){
	var color=$('#id').css('background-color');
	$('#bigsquare').css('background-color',color);
}