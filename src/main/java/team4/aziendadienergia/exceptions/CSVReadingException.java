package team4.aziendadienergia.exceptions;

public class CSVReadingException extends RuntimeException {
    public CSVReadingException( Exception e) {
        super("----- ERROR WHILE READING CSV FILE -------", e);
    }
}
