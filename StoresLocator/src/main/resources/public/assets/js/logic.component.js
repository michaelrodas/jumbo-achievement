var x = document.getElementById("demo");
    var map;
    var bounds = new google.maps.LatLngBounds();

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition, showError);
            navigator.geolocation.getCurrentPosition(showResult);
        } else {
            x.innerHTML = "Geolocation is not supported by this browser.";
        }
    }

    function showPosition(position) {
        //x.innerHTML = "Latitude: " + position.coords.latitude +
        //"<br>Longitude: " + position.coords.longitude;

        var lat = position.coords.latitude;
        var lon = position.coords.longitude;
        document.getElementById("userposition").innerHTML="<br>Your position is:" +
            "<br>Latitude: "+lat + " Longitude: "+lon+"<br>"
        var latlon = new google.maps.LatLng(lat, lon)
        var mapholder = document.getElementById('mapholder')
        mapholder.style.height = '250px';
        mapholder.style.width = '100%';

        var myOptions = {
        center:latlon,zoom:14,
        mapTypeId:google.maps.MapTypeId.ROADMAP,
        mapTypeControl:false,
        navigationControlOptions:{style:google.maps.NavigationControlStyle.SMALL}
        }

        map = new google.maps.Map(document.getElementById("mapholder"), myOptions);
        var marker = new google.maps.Marker({position:latlon,map:map,title:"You are here!"});
        marker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png')
        bounds.extend(marker.position);
        $("body").append("<br>")
    }

    function showError(error) {
        switch(error.code) {
            case error.PERMISSION_DENIED:
                x.innerHTML = "User denied the request for Geolocation."
                break;
            case error.POSITION_UNAVAILABLE:
                x.innerHTML = "Location information is unavailable."
                break;
            case error.TIMEOUT:
                x.innerHTML = "The request to get user location timed out."
                break;
            case error.UNKNOWN_ERROR:
                x.innerHTML = "An unknown error occurred."
                break;
        }
    }

    function showResult(position)
    {
            var lat = position.coords.latitude;
            var lon = position.coords.longitude;

            $.get("./stores/"+lat+"/"+lon, function (resultData) {
            $("#resultcontent").append("<div>The closest stores to your position are:</div>")
            $("#resultcontent").append("<br>")
            for (var i = 0; i < resultData.length; i++) {
                $("#resultcontent").append("<div>Store "+(i+1)+":")
                var distance = parseFloat(JSON.stringify(resultData[i].distanceToStore))
                $("#resultcontent").append("Distance to store: "+ ((distance<1000)?distance+" meters":(distance/1000)+" km"))
                $("#resultcontent").append("<br>Store name: "+JSON.stringify(resultData[i].store.addressName))
                $("#resultcontent").append("<br><br></div>")

                latlon = new google.maps.LatLng(resultData[i].store.latitude, resultData[i].store.longitude)
                marker = new google.maps.Marker({position:latlon,map:map,title:resultData[i].store.addressName});
                marker.setIcon('http://maps.google.com/mapfiles/ms/icons/blue-dot.png')
                bounds.extend(marker.position);
                marker.setMap(map);
                map.fitBounds(bounds);
            }
            });
    }