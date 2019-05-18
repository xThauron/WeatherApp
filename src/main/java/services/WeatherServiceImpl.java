package services;

import models.openWeatherAPI.WeatherResponse;
import models.weather.City;
import models.weather.Weather;
import repositories.WeatherRepository;
import rest.OpenWeatherClient;
import validators.WeatherValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class WeatherServiceImpl implements WeatherService {
    @Inject
    private WeatherRepository weatherRepository;
    @Inject
    private WeatherValidator weatherValidator;
    @Inject
    private OpenWeatherClient openWeatherClient;


    @Override
    public Weather getWeather(String id) {
        Weather weather = weatherRepository.getWeatherById(id);
        if(weather == null) {
            addWeather(id);
        } else {
            if(weatherValidator.isExpired(weather)) {
                updateWeather(weather);
            }
        }
        return weatherRepository.getWeatherById(id);
    }

    @Override
    public void addWeather(String id) {
        WeatherResponse weatherResponse = openWeatherClient.getWeatherResponse(id);
        Weather weather = new Weather(
                new City(id, weatherResponse.getName()),
                weatherResponse.getMain().getTemp(),
                weatherResponse.getMain().getPressure(),
                weatherResponse.getWind().getSpeed(),
                weatherResponse.getClouds().getAll()
        );

        weatherRepository.add(weather);
    }

    @Override
    public void removeWeather(Weather weather) {
        weatherRepository.remove(weather);
    }

    @Override
    public void updateWeather(Weather weather) {
        String id = weather.getCity().getId();
        removeWeather(weather);
    }
}
