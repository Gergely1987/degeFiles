$(function() {
  updateTable = function() {
    $.ajax({
            url: "api/locations",
            type : "GET",
            dataType: 'json',
            success : function(json) {
                                $("#locationsTable").html("");
                               $.each(json, function(idx, location) {
                                    $("#locationsTable").append("<tr><td>" + location.name + "</td><td>" + location.lat + ", " + location.lon + "</td></tr>");
                                });

                            },
                            error: function(xhr, resp, text) {
                                console.log(xhr, resp, text);
                            }
        });
  };

  $("#addLocationForm").submit(function(event) {
    var name = $("#name").val();
    var fields = $("#coordinate").val().split(',');
    var lat = parseFloat(fields[0]);
    var lon = parseFloat(fields[1]);
    var data = {
      'name' : name,
      'lat' : lat,
      'lon' : lon
    }
    $.ajax({
        url: "api/locations",
        type : "POST",
        dataType: 'json',
        contentType: "application/json; charset=UTF-8",
        data : JSON.stringify(data),
        success : function(result) {
                            $("#addLocationForm").find("input[type=text]").val("");
                            updateTable();
                        },
                        error: function(xhr, resp, text) {
                            console.log(xhr, resp, text);
                        }
    });
    event.preventDefault();
  });

  updateTable();


});