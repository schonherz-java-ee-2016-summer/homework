/**
 * Created by Attila on 2016.07.21..
 */
function  showAddCommentField() {
    var code ="<div>" +
        "        <label for='user'>Add comment:</label>" +
        "        <input id='user' name='user' type='text'>" +
        "      </div>" +
        "      <button type='submit'>Send</button>";

    document.getElementById('addComment').innerHTML = code;
}