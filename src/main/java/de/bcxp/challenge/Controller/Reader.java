package de.bcxp.challenge.Controller;

import de.bcxp.challenge.Exceptions.InvalidDataSourceException;

import java.util.List;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public interface Reader {
    List<?> parse(char seperator) throws InvalidDataSourceException;
}
