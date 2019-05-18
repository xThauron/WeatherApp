package validators;

import models.weather.Weather;

import javax.inject.Inject;

public interface WeatherValidator {
    boolean isExpired(Weather weather);
}
