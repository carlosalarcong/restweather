package cl.tecnova.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherEntryTests {
	
	private JacksonTester<WeatherEntry> json;

    private WeatherEntry weatherEntry;
    
    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
        weatherEntry = new WeatherEntry();
        weatherEntry.setWeatherId(new Integer(1234));
        weatherEntry.setTemperature(72.0);
        weatherEntry.setWeatherIcon("Soleado con algunas nubes");
    }

	@Test
	public void serializeJson() throws IOException {
        assertThat(this.json.write(weatherEntry))
                .extractingJsonPathNumberValue("@.weatherId")
                .isEqualTo(1234);
        assertThat(this.json.write(weatherEntry))
                .extractingJsonPathNumberValue("@.temperature")
                .isEqualTo(72.0);
        assertThat(this.json.write(weatherEntry))
                .extractingJsonPathStringValue("@.weatherIcon")
                .isNotEqualTo("Soleado con algunas nubes");
    }

}
