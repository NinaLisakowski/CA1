let table = document.getElementById("table")
document.getElementById("btn").onclick = returnTableData;

let url = "api/groupmembers/all";
let jsondata;

fetch(url)
  .then(res => res.json()) //in flow1, just do it
  .then(data => { 
      jsondata=data;      
})

function returnTableData(){
    fetch(url)
    table.innerHTML = maketable(jsondata);
}
function maketable(array){
    let returnstring = "<thead><tr>"
    let keysarray = Object.keys(array[0]);
    keysarray.forEach(function(item){
        returnstring += `<th>${item}</th>`
    })
    returnstring += "</tr></thead><tbody>"
    array.forEach(function(item){
        let values = Object.values(item);
        returnstring += "<tr>";
        values.forEach(function(value){
            returnstring += `<td>${value}</td>`;
        });
        returnstring += "</tr>";
    });
    returnstring += "</tbody>";
    return returnstring;
}

