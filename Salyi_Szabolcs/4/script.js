function colourBigBox(c) {
	var colour=document.getElementById(c);
	colour=getComputedStyle(colour).backgroundColor;
	document.getElementById("black").style.backgroundColor=colour;
}