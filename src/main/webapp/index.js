let table = document.getElementById("table")
document.getElementById("btn").onclick = returnTableData;

let url = "api/groupmembers/all";

function returnTableData(){
    console.log(fetch(url))
    table.innerHTML = maketable(fetch(url));
}
function maketable(array){
    let returnstring = "<thead><tr>"
    console.log(Object.keys());
    console.log(Object.keys(array[0]));
    let keysarray = Object.keys();
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

fetch(url)
  .then(res => res.json()) //in flow1, just do it
  .then(data => { return data
   // Inside this callback, and only here, the response data is available
   //console.log("data",data);
  /* data now contains the response, converted to JavaScript
     Observe the output from the log-output above
     Now, just build your DOM changes using the data*/       
})
