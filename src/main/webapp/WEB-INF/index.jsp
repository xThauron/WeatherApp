<%@ page import="models.weather.Weather" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    Weather weather = (Weather)request.getAttribute("Weather");
%>
<html>
<head>
    <title>Weather APP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <style type="text/css">
        body {
            padding-top: 5rem;
        }
        .starter-template {
            padding: 3rem 1.5rem;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="starter-template">e
        <div class="row justify-content-center align-items-center">
            <div class="col-md-6">
                <form method="post">
                    <h2>Check weather in city you want</h2>
                    <div class="form-group mt-4">
                        <label for="city">Choose city</label>
                        <select class="form-control" id="city" name="cityId">
                            <option value="6695624">Warszawa</option>
                            <option value="7531890">Gdańsk</option>
                            <option value="3094802">Kraków</option>
                            <option value="3081368">Wrocław</option>
                            <option value="7530858">Poznań</option>
                            <option value="3093133">Łódź</option>
                            <option value="3096472">Katowice</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Check weather</button>
                    </div>
                </form>
                <% if(weather != null) { %>
                    <div class="row justify-content-md-center mt-4">
                        <div class="col-md-4 font-weight-bold">City</div>
                        <div class="col-md-2"><% out.print(weather.getCity().getName()); %></div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-md-4 font-weight-bold">Temperature</div>
                        <div class="col-md-2"><% out.print(weather.getTemperature()); %></div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-md-4 font-weight-bold">Pressure</div>
                        <div class="col-md-2"><% out.print(weather.getPressure()); %></div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-md-4 font-weight-bold">Wind speed</div>
                        <div class="col-md-2"><% out.print(weather.getWindSpeed()); %></div>
                    </div>
                    <div class="row justify-content-md-center">
                        <div class="col-md-4 font-weight-bold">Clouds</div>
                        <div class="col-md-2"><% out.print(weather.getClouds()); %></div>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
