package de.bcxp.challenge.Logic;

import de.bcxp.challenge.Controller.CountryReader;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Exceptions.InvalidEntryDataException;
import de.bcxp.challenge.Models.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class CountryService {

    private final Logger logger = LoggerFactory.getLogger(CountryService.class);

    private final CountryReader countryDataSource;
    private final char seperator;


    public CountryService(CountryReader countryDataSource, char seperator) {
        this.countryDataSource = countryDataSource;
        this.seperator = seperator;
    }


    public String getCountryWithHighestPopulationDensity() throws InvalidDataSourceException {

        List<Country> measurements = (List<Country>) countryDataSource.parse(seperator);

        logger.info("sorting the measurements descending");
        measurements.sort(new Comparator<Country>() {
            @Override
            public int compare(Country country1, Country country2) {
                try {
                    if (country1.getPopulationDensity() > country2.getPopulationDensity()){
                        return -1;
                    }
                } catch (InvalidEntryDataException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
                return 0;
            }
        });
        logger.info("measurements are sorted descending");
        return measurements.get(0).getName();
    }

}
