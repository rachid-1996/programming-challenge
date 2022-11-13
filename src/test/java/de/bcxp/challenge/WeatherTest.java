package de.bcxp.challenge;

import de.bcxp.challenge.Exceptions.InvalidEntryDataException;
import de.bcxp.challenge.Models.Country;
import de.bcxp.challenge.Models.DayWeather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class WeatherTest {

    @Test
    @DisplayName("should calculate the difference between two positive temperatures")
    void getTemperatureSpreadBetweenTwoPositiveTemperature() {
        DayWeather dayWeather = DayWeather.builder().maximumTemperature(12).minimumTemperature(2).build();

        try {
            assertEquals(10, dayWeather.getTemperatureSpread());
        } catch (InvalidEntryDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("should calculate the difference between two negative temperatures")
    void getTemperatureSpreadBetweenTwoNegativeTemperature() {
        DayWeather dayWeather = DayWeather.builder().maximumTemperature(-2).minimumTemperature(-32).build();

        try {
            assertEquals(30, dayWeather.getTemperatureSpread());
        } catch (InvalidEntryDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("should calculate the difference between two temperatures")
    void getTemperatureSpreadBetweenTemperature() {
        DayWeather dayWeather = DayWeather.builder().maximumTemperature(20).minimumTemperature(-32).build();

        try {
            assertEquals(52, dayWeather.getTemperatureSpread());
        } catch (InvalidEntryDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("should catch the exception due to false input")
    void getTemperatureSpreadBetweenFalseTemperature() {
        DayWeather dayWeather = DayWeather.builder().maximumTemperature(10).minimumTemperature(32).build();

        try {
            dayWeather.getTemperatureSpread();
        } catch (InvalidEntryDataException e) {
            assertEquals("The entry data is invalid", e.getMessage() );
        }
    }


}
