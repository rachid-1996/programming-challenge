package de.bcxp.challenge.Models;

import com.opencsv.bean.CsvBindByName;
import de.bcxp.challenge.Exceptions.InvalidEntryDataException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayWeather {

    private final Logger logger = LoggerFactory.getLogger(DayWeather.class);

    @CsvBindByName(column = "Day")
    private int dayOfTheMonth;

    @CsvBindByName(column = "MnT")
    private int minimumTemperature;

    @CsvBindByName(column = "MxT")
    private int maximumTemperature;

    public int getTemperatureSpread() throws InvalidEntryDataException  {

        if (minimumTemperature > maximumTemperature){
            logger.error("The given minimum of Temperature is bigger than the given maximum Temperature");
            throw new InvalidEntryDataException();
        }
        logger.info("calculating the difference between maximum temperature and minimum temperature for Day %d",
                dayOfTheMonth);
        return maximumTemperature - minimumTemperature;
    }
}