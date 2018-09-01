package cl.tecnova.controller;


import cl.tecnova.beans.Weather;
import cl.tecnova.beans.WeatherForecast;
import cl.tecnova.exception.InvalidCityCodeException;
import cl.tecnova.exception.InvalidMetricCodeException;
import cl.tecnova.service.WeatherService;
import cl.tecnova.utils.ValidationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clima")
public class WeatherController {

    private final WeatherService weatherService;

    private ValidationUtils validationUtils;

    public WeatherController(WeatherService weatherService, ValidationUtils validationUtils) {
        this.weatherService = weatherService;
        this.validationUtils = validationUtils;
    }

    @RequestMapping("/{city}")
    public Weather getCity(@PathVariable String city) {
        if (!validationUtils.isValidCity(city)) {
            throw new InvalidCityCodeException();
        }
        return this.weatherService.getCity(city);
    }

    @RequestMapping("/{city}/{metric}")
    public Weather getMetric(@PathVariable String city, @PathVariable String metric) {

        if (!validationUtils.isValidCity(city)) {
            throw new InvalidCityCodeException();
        }
        if(!validationUtils.isValidMetric(metric)){
            throw new InvalidMetricCodeException();
        }
        return this.weatherService.getMetric(city, metric);
    }

    @RequestMapping("/actual/{country}/{city}")
    public Weather getWeather(@PathVariable String country,
                              @PathVariable String city) {
        if (!validationUtils.isValidCity(city)) {
            throw new InvalidCityCodeException();
        }
        if (!validationUtils.isValidCountry(country)) {
            throw new InvalidCityCodeException();
        }
        return this.weatherService.getWeather(country, city);
    }

    @RequestMapping("/semanal/{country}/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String country,
                                              @PathVariable String city) {

        if (!validationUtils.isValidCity(city)) {
            throw new InvalidCityCodeException();
        }
        if (!validationUtils.isValidCountry(country)) {
            throw new InvalidCityCodeException();
        }

        return this.weatherService.getWeatherForecast(country, city);
    }
}
