let url = "api/cars/all";
let globalList;
let cars = [];

let btn = document.getElementById("fetchButton");
btn.addEventListener("click", fetching);

function fetching() {
    fetch(url)
        //            .then(response => response.text())
        //            .then(text => console.log(text))        
        .then(Response => Response.json())
        .then(data => {
            cars = data;
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

//Filter price
document.getElementById("filterPriceBtn").onclick = filterPrice;
  
function filterPrice(evt){
    evt.preventDefault();
    let price = document.getElementById("priceInput");
    let lessThanCars = cars.filter((car) => car.price < price.value);
    document.getElementById("table").innerHTML = updateTable(lessThanCars);
}

//Filter year
document.getElementById("filterYearBtn").onclick = filterYear;
  
function filterYear(evt){
    evt.preventDefault();
    let year = document.getElementById("yearInput");
    let newerCars = cars.filter((car) => car.year > year.value);
    document.getElementById("table").innerHTML = updateTable(newerCars);
}

//Filter make
document.getElementById("filterMakeBtn").onclick = filterMake;
  
function filterMake(evt){
    evt.preventDefault();
    let make = document.getElementById("makeInput");
    let newCars = cars.filter((car) => car.make == make.value);
    document.getElementById("table").innerHTML = updateTable(newCars);
}