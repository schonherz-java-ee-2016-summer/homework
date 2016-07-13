function colourBlue() {
	document.getElementById("black").style.backgroundColor="#00EEFF";
}
function colourGreen() {
	document.getElementById("black").style.backgroundColor="#44FF44";
}
function colourRed() {
	document.getElementById("black").style.backgroundColor="#DD0000";
} 
function colourBigBox(c) {
	var colour=document.getElementById(c);
	colour=getComputedStyle(colour).backgroundColor;
	document.getElementById("black").style.backgroundColor=colour;
}