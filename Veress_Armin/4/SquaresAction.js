function katt1(){document.getElementById("Fourth").style.backgroundColor=getColor('First');}

function katt2(){document.getElementById("Fourth").style.backgroundColor=getColor('Second');}

function katt3(){document.getElementById("Fourth").style.backgroundColor=getColor('Third');}

function getColor(id) {
    var elem = document.getElementById(id);
    var getStyle = getComputedStyle(elem);
    return getStyle.backgroundColor;
}