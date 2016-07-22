/**
 * Created by Attila on 2016.07.21..
 */
function validatePost() {
    var x = document.forms["addPost"]["user"].value;
    var y = document.forms["addPost"]["title"].value;
    var z = document.forms["addPost"]["content"].value;

    if (x == null || x == "") {
        alert("Please enter your name!");
        return false;
    }

    else if (y == null || y == "") {
        alert("Please enter the title of your post!");
        return false;
    }

    else if (z == null || z == "") {
        alert("Please enter the content of the post!");
        return false;
    }

    else {return true;}
}

function validateComment() {
    var x = document.forms["addComment"]["content"].value;

    if (x == null || x == "") {
        alert("Please enter your comment!");
        return false;
    }

    else {return true;}
}
