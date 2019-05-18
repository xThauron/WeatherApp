package services;

import models.weather.Weather;

public interface WeatherService {
    Weather getWeather(String id);
    void addWeather(String id);
    void removeWeather(Weather weather);
    void updateWeather(Weather weather);
}
