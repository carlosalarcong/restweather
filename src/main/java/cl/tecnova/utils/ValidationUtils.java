package cl.tecnova.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationUtils.class);

    public boolean isValidCity(String cityCode) {
        LOGGER.info("Validación del código de ciudad");
        return (!cityCode.isEmpty());
    }

    public boolean isValidCountry(String countryCode) {
        LOGGER.info("Validación del código de país");
        return (!countryCode.isEmpty());
    }

    public boolean isValidMetric(String metrica) {
        LOGGER.info("Validación del código de país");
        return(metrica.equals("imperial") || metrica.equals("metric") || metrica.equals("kelvin"));

    }

}
