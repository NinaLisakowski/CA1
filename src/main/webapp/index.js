let url = "api/groupmembers/all";
let table = document.getElementById("table")
document.getElementById("btn").onclick = fetching;

function fetching() {
    fetch(url)
            .then(res => res.json()) 
            .then(data => {
                maketable(data);
            })
}

function maketable(array) {
    let returnstring = "<thead><tr>"
    let keysarray = Object.keys(array[0]);
    keysarray.forEach(function (item) {
        returnstring += `<th>${item}</th>`
    })
    returnstring += "</tr></thead><tbody>"
    array.forEach(function (item) {
        let values = Object.values(item);
        returnstring += "<tr>";
        values.forEach(function (value) {
            returnstring += `<td>${value}</td>`;
        });
        returnstring += "</tr>";
    });
    returnstring += "</tbody>";
    table.innerHTML = returnstring;
}

