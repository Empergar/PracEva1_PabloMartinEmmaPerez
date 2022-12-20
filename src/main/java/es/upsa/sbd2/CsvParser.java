package es.upsa.sbd2;

import java.util.ArrayList;
import java.util.List;

public interface CsvParser <T>{

    T parse(String csvLine);

    default List<String> getListaTelefonos(List<String> tlfs)
    {
        //Creacion de la lista de los telefonos que va a devolver la funcion
        List<String> telefonos = new ArrayList<>();

        //Se comprueba por cada telefono si su campo esta vacio o no
        tlfs.forEach( tlf -> {
           //Si no lo esta se añade a la lista
            if (!tlf.isEmpty()) {
                telefonos.add(tlf);
            }
        });
        return telefonos;
    }

}
