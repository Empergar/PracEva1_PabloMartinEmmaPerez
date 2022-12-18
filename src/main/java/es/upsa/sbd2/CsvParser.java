package es.upsa.sbd2;

import java.util.List;

public interface CsvParser <T>{

    T parse(String csvLine);

    List<T> getListaTelefonos(String tlf1, String tlf2, String tlf3)
    {

    }

}
