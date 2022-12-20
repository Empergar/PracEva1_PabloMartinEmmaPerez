package es.upsa.sbd2;

import java.util.ArrayList;
import java.util.List;

public interface CsvParser <T>{

    T parse(String csvLine);

    default List<String> getListaTelefonos(List<String> tlfs)
    {
        List<String> telefonos = new ArrayList<>();
        tlfs.forEach( tlf -> {
            if (!tlf.isEmpty()) {
                telefonos.add(tlf);
            }
        });
        return telefonos;
    }

}
