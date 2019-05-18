package repositories;

import models.weather.Weather;

public interface WeatherRepository {
    Weather getWeatherById(String id);
    void add(Weather weather);
    void remove(Weather weather);
}
