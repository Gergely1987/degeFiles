
window.onload=function(){
    updateLocationsTable();
     var addLocationForm = document.getElementById("addLocationForm");
        addLocationForm.onsubmit = addLocation;
}

function addLocation() {
    var name = document.getElementById('name').value;
    var fields = document.getElementById('coordinate').value.split(',');
    var lat = parseFloat(fields[0]);
    var lon = parseFloat(fields[1]);
    var data = {
        'name' : name,
        'lat' : lat,
        'lon' : lon
    }
    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'api/locations');
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.responseType = 'json';
    xhr.onreadystatechange = function () {
      var DONE = 4;
      var OK = 200;
      if (xhr.readyState === DONE) {
        if (xhr.status === OK) {
          updateLocationsTable();
        } else {
          console.log('Error: ' + xhr.status);
        }
      }
    };
    xhr.send(JSON.stringify(data));
    return false;
}


function updateLocationsTable() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'api/locations');
    xhr.onreadystatechange = function () {
      var DONE = 4;
      var OK = 200;
      if (xhr.readyState === DONE) {
        if (xhr.status === OK) {
          var locations = JSON.parse(xhr.responseText);
          var locationsTable = document.getElementById("locationsTable");
          locationsTable.innerHTML = "";
          for (var i = 0; i < locations.length; i++) {
            locationsTable.innerHTML += "<tr><td>" + locations[i].name + "</td><td>" + locations[i].lat + ", " + locations[i].lon + "</td></tr>";
          }
        } else {
          console.log('Error: ' + xhr.status);
        }
      }
    };
    xhr.send(null);
}