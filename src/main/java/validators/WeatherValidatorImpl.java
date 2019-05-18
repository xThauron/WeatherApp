package validators;

import models.weather.Weather;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class WeatherValidatorImpl implements WeatherValidator {
    public boolean isExpired(Weather weather) {
        return (new Date().getTime() - weather.getDate().getTime() >= 10*60*1000);
    }
}
