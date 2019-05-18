package repositories;

import models.weather.Weather;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class WeatherRepositoryImpl implements WeatherRepository {
    private List<Weather> weatherList = new ArrayList<>();

    @Override
    public Weather getWeatherById(String id) {
        for(Weather weather : weatherList) {
            if(weather.getCity().getId().equals(id))
                return weather;
        }

        return null;
    }

    @Override
    public void add(Weather weather) {
        weatherList.add(weather);
    }

    @Override
    public void remove(Weather weather) {
        weatherList.remove(weather);
    }
}
