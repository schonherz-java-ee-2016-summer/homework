/**
 * Created by Attila on 2016.07.21..
 */
function validatePost() {
    var name = document.forms["addPost"]["user"].value;
    var title = document.forms["addPost"]["title"].value;
    var content = document.forms["addPost"]["content"].value;
    if (name === null || name === "") {
        alert("Please enter your name!");
        return false;
    } else if (title === null || title === "") {
        alert("Please enter the title of your post!");
        return false;
    } else if (content === null || content === "") {
        alert("Please enter the content of the post!");
        return false;
    } else {
        return true;
    }
}

function validateComment() {
    var content = document.forms["addComment"]["content"].value;
    if (content === null || content === "") {
        alert("Please enter your comment!");
        return false;
    } else {
        return true;
    }
}
