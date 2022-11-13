package de.bcxp.challenge;

import de.bcxp.challenge.Controller.CountryReader;
import de.bcxp.challenge.Exceptions.InvalidDataSourceException;
import de.bcxp.challenge.Logic.CountryService;
import de.bcxp.challenge.Models.Country;
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
public class CountryServiceTest {

    private final CountryReader countryReader = Mockito.mock(CountryReader.class);
    private CountryService countryService = new CountryService(countryReader, ',');

    @Test
    @DisplayName("should return name of country with highest population density")
    void getCountryWithHighestPopulationDensity(){

        Country country1 = Country.builder().name("Germany").populationString("1000").areaString("200").build();
        Country country2 = Country.builder().name("Tunisia").populationString("1000").areaString("45").build();
        Country country3 = Country.builder().name("France").populationString("1000").areaString("8585").build();
        Country country4 = Country.builder().name("Italy").populationString("450").areaString("23").build();
        Country country5 = Country.builder().name("Spain").populationString("7500").areaString("23").build();

        List<Country> list = Arrays.asList(country1, country2, country3, country4, country5);

        try {
            Mockito.when(countryReader.parse(',')).thenReturn(list);
            assertEquals("Spain", countryService.getCountryWithHighestPopulationDensity());
        } catch (InvalidDataSourceException e) {
            e.printStackTrace();
        }
    }

}
