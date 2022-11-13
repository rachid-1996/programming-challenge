package de.bcxp.challenge.Exceptions;

/**
 * TODO: qxz2g68 - Missing JavaDoc
 *
 * @author Rachid Ghorbel, Rachid.Ghorbel@extern.cognizant-mobility.com
 */
public class InvalidEmptyFileException extends InvalidDataSourceException {
    public InvalidEmptyFileException() {
        super("The given file is empty");
    }
}
