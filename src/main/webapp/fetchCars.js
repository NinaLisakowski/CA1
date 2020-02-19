let url = "api/cars/all";
let globalList;

let btn = document.getElementById("fetchButton");
btn.addEventListener("click", fetching);

function fetching() {
    fetch(url)
        //            .then(response => response.text())
        //            .then(text => console.log(text))        
        .then(Response => Response.json())
        .then(data => {
            console.log("data", data);
            document.getElementById("table").innerHTML = updateTable(data);
        });
}

function updateTable(CarArray) {
    let htmlStringHead = "<tr><th>Id</th><th>Year</th><th>Make</th><th>Model</th><th>Price</th></tr>";
    console.log(htmlStringHead);
    let htmlStringValue = "<tr>";
    CarArray.forEach(element => {
        console.log(element);
        let temp = Object.values(element).map(function(a) {
                return "<td>" + a + "</td>";
            }).join("") +
            "</tr>";
        htmlStringValue += temp;
    });
    console.log(htmlStringValue);
    globalList = htmlStringHead + htmlStringValue;
    return htmlStringHead + htmlStringValue;
}