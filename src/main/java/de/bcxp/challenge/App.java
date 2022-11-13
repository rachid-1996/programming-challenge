package de.bcxp.challenge;

import de.bcxp.challenge.Controller.CountryReader;
import de.bcxp.challenge.Controller.WeatherReader;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Logic.CountryService;
import de.bcxp.challenge.Logic.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    private static final String WEATHER_FILE_PATH = "src/main/resources/de/bcxp/challenge/weather.csv";
    private static final String COUNTRY_FILE_PATH = "src/main/resources/de/bcxp/challenge/countries.csv";

    private static final char WEATHER_SEPERATOR = ',';
    private static final char COUNTRY_SEPERATOR = ';';

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) throws InvalidDataSourceException {

        logger.info("Determining the day with smallest temperature spread");
        WeatherReader weatherDataSource = new WeatherReader(WEATHER_FILE_PATH);
        WeatherService weatherService = new WeatherService(weatherDataSource,WEATHER_SEPERATOR);
        try {
            int dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread();
            System.out.printf("Day with smallest temperature spread: %d%n", dayWithSmallestTempSpread);
        }catch (InvalidDataSourceException e){
            logger.error(e.getMessage());
        }

        logger.info("Determining the day with smallest temperature spread");
        CountryReader countryDataSource = new CountryReader(COUNTRY_FILE_PATH);
        CountryService countryService = new CountryService(countryDataSource, COUNTRY_SEPERATOR);
        try {
            String countryWithHighestPopulationDensity = countryService.getCountryWithHighestPopulationDensity();
            System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
        }catch (InvalidDataSourceException e){
            logger.error(e.getMessage());
        }

    }
}
