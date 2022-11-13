package de.bcxp.challenge.Logic;

import de.bcxp.challenge.Controller.WeatherReader;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Exceptions.InvalidEntryDataException;
import de.bcxp.challenge.Models.DayWeather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class WeatherService {

    private final Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherReader weatherDataSource;
    private final char seperator;


    public WeatherService(WeatherReader weatherDataSource, char seperator) {
        this.weatherDataSource = weatherDataSource;
        this.seperator = seperator;
    }


    public int getDayWithSmallestTempSpread() throws InvalidDataSourceException {

        List<DayWeather> measurements = (List<DayWeather>) weatherDataSource.parse(seperator);

        logger.info("sorting the measurements ascending");
        measurements.sort(new Comparator<DayWeather>() {
            @Override
            public int compare(DayWeather day1, DayWeather day2) {
                try {
                    if (day1.getTemperatureSpread() < day2.getTemperatureSpread()){
                        return -1;
                    }
                } catch (InvalidEntryDataException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
                return 0;
            }
        });
        logger.info("measurements are sorted ascending");
        return measurements.get(0).getDayOfTheMonth();
    }


}
