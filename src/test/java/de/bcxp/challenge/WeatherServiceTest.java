package de.bcxp.challenge;

import de.bcxp.challenge.Controller.WeatherReader;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Logic.WeatherService;
import de.bcxp.challenge.Models.DayWeather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class WeatherServiceTest {

    private final WeatherReader weatherReader = Mockito.mock(WeatherReader.class);
    private WeatherService weatherService = new WeatherService(weatherReader, ',');

    @Test
    @DisplayName("should return name of country with highest population density")
    void getCountryWithHighestPopulationDensity(){

        DayWeather measurement1 = DayWeather.builder().dayOfTheMonth(30).minimumTemperature(-70).maximumTemperature(40).build();
        DayWeather measurement2 = DayWeather.builder().dayOfTheMonth(12).minimumTemperature(22).maximumTemperature(30).build();
        DayWeather measurement3 = DayWeather.builder().dayOfTheMonth(05).minimumTemperature(79).maximumTemperature(79).build();
        DayWeather measurement4 = DayWeather.builder().dayOfTheMonth(22).minimumTemperature(12).maximumTemperature(26).build();
        DayWeather measurement5 = DayWeather.builder().dayOfTheMonth(1).minimumTemperature(80).maximumTemperature(143).build();

        List<DayWeather> list = Arrays.asList(measurement1, measurement2, measurement3, measurement4, measurement5);

        try {
            Mockito.when(weatherReader.parse(',')).thenReturn(list);
            assertEquals(5, weatherService.getDayWithSmallestTempSpread());
        } catch (InvalidDataSourceException e) {
            e.printStackTrace();
        }
    }

}
