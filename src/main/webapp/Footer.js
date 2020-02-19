let linkBack = document.createElement("input");
linkBack.type = "button";
linkBack.onclick = function() {
    location.href = "index.html";
};
linkBack.value = "Back to main menu";
linkBack.className = "myButton";
document.body.appendChild(linkBack);