package rest;

import models.openWeatherAPI.WeatherResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class OpenWeatherClient {
    private final static String URI = "https://api.openweathermap.org/data/2.5/weather";
    private final static String KEY = "078cfa020a13fc2c5835a36ac6a4cc61";

    public WeatherResponse getWeatherResponse(String id) {
        return ClientBuilder.newClient()
                .target(URI)
                .queryParam("appid", KEY)
                .queryParam("mode", "json")
                .queryParam("id", id)
                .queryParam("units", "metric")
                .request(MediaType.APPLICATION_JSON)
                .get(WeatherResponse.class);
    }
}
