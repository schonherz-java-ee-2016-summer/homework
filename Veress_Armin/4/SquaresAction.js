function katt(obj){document.getElementById("Fourth").style.backgroundColor=getColor(obj);}

function getColor(id) {
    var elem = document.getElementById(id);
    var getStyle = getComputedStyle(elem);
    return getStyle.backgroundColor;
}