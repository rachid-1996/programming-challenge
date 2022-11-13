package de.bcxp.challenge.Controller;

import com.opencsv.bean.CsvToBeanBuilder;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Exceptions.InvalidEmptyFileException;
import de.bcxp.challenge.Models.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class CountryReader implements  Reader{

    private final Logger logger = LoggerFactory.getLogger(CountryReader.class);

    private final String filePath;

    public CountryReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Country> parse(char seperator) throws InvalidDataSourceException {
        List<Country> measurements = new ArrayList<Country>();
        try {
            measurements = new CsvToBeanBuilder<Country>(new FileReader(filePath))
                    .withSeparator(seperator)
                    .withType(Country.class)
                    .build().parse();
        } catch (FileNotFoundException e) {
            logger.error("The file %s is not found. %n", filePath);
            throw new InvalidDataSourceException(String.format("Error: File %s is not found. %n", filePath));
        }
        logger.info(String.format("%d measurements are read from file %s%n", measurements.size(), filePath));
        if (measurements.size() == 0){
            logger.error("The file %s is empty %n", filePath);
            throw new InvalidEmptyFileException();
        }
        return measurements;
    }
}
