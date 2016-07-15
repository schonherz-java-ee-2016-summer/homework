function colorChange(id){
   var attr = document.getElementById(id);
   var color = getComputedStyle(attr).getPropertyValue("background-color");
   document.getElementById("colored").style.backgroundColor = color;
}
