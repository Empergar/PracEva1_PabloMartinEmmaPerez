package es.upsa.sbd2;

public interface CsvParser <T>{

    public T parse(String csvLine);

}
