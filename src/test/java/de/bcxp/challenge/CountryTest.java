package de.bcxp.challenge;

import de.bcxp.challenge.Exceptions.InvalidEntryDataException;
import de.bcxp.challenge.Models.Country;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class CountryTest {

    @Test
    @DisplayName("should calculate population density")
    void getPopulationDensity() {
        Country country = Country.builder().populationString("4.036.355,00").areaString("5,00").build();

        try {
            assertEquals(807271.00, country.getPopulationDensity());
        } catch (InvalidEntryDataException e) {
            e.printStackTrace();
        }


    }

    @Test
    @DisplayName("should catch the exception due to false input")
    void getPopulationDensityWithFalseArea() {
        Country country = Country.builder().populationString("4.036.355,00").areaString("0").build();

        try {
            country.getPopulationDensity();
        } catch (InvalidEntryDataException e) {
            assertEquals("The entry data is invalid", e.getMessage() );
        }
    }

}
