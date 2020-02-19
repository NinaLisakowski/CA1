/*    
 Created on : 19. feb. 2020, 09.01.55
 Author     : carol
 */
let url = "api/joke";
let urlAll = "api/joke/all"; 

//Fetch all jokes
fetch(urlAll)
        .then(res => res.json()) 
        .then(data => {
            createTable(data);
        })
        
function createTable(arr) {
    let tableBody = "<tbody>";
    
    arr.forEach(function (item) {
        let values = Object.values(item);
        tableBody += "<tr>";
        values.forEach(function (value) {
            tableBody += `<td>${value}</td>`;
        });
        tableBody += "</tr>";
    });
    tableBody += "</tbody>";
    
    document.getElementById("jokeTable").innerHTML += tableBody;
}

//Fetch joke from id
let btn = document.getElementById("idBtn");
btn.addEventListener("click", fetchId);

function fetchId(evt) {
    evt.preventDefault();
    const finalURL = url + "/" + document.getElementById("inputId").value;
    fetch(finalURL)
            .then(resp => resp.json())
            .then(data => {
                document.getElementById("joke").innerHTML = Object.values(data);
            });
}

//Fetch random joke
let rbtn = document.getElementById("randomBtn");
rbtn.addEventListener("click", fetchRandom);

function fetchRandom(evt) {
    evt.preventDefault();
    const finalURL = url + "/random";
    fetch(finalURL)
            .then(resp => resp.json())
            .then(data => {
                document.getElementById("joke").innerHTML = Object.values(data);
            });
}

