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
public class Country {

    private final Logger logger = LoggerFactory.getLogger(Country.class);

    @CsvBindByName(column = "Name")
    private String name;

    @CsvBindByName(column = "Population")
    private String populationString;

    @CsvBindByName(column = "Area (km²)")
    private String areaString;

    public double getPopulationDensity() throws InvalidEntryDataException{
        double population = Double.parseDouble(
                populationString.replace(".","").replace(",","."));
        double area = Double.parseDouble(
                areaString.replace(".","").replace(",","."));

        if (area == 0){
            logger.error("The area is given as 0 km²");
            throw new InvalidEntryDataException();
        }
        logger.info("calculating the population density of the country %s", name);

        return population / area;
    }

}
