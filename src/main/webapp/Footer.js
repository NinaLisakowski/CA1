let linkBack = document.createElement("input");
linkBack.type = "button";
linkBack.onclick = function() {
    location.href = "index.html";
};
linkBack.value = "LinkBack here."
linkBack.className = "myButton";
document.body.appendChild(linkBack);