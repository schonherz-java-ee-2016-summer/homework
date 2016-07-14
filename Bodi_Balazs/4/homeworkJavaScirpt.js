function onClickColorChange(id) {
	var item = document.getElementById(id);
	var styleOfTheItem = getComputedStyle(item);
	document.getElementById("ColorableBlock").style.backgroundColor = styleOfTheItem.backgroundColor;
}