function changeBigBg(id) {
    var element = document.getElementById(id);
    var getStyle = getComputedStyle(element);
    var getBgColor = getStyle.backgroundColor;
    
    document.getElementById("big").style.backgroundColor = getBgColor;
}
