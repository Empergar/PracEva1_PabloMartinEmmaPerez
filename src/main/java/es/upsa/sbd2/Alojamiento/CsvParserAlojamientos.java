package es.upsa.sbd2.Alojamiento;
import es.upsa.sbd2.CsvParser;
import es.upsa.sbd2.Enumeraciones.CategoriaAlojamiento;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;

import java.util.List;

public class CsvParserAlojamientos implements CsvParser<Alojamiento> {

    @Override
    public Alojamiento parse(String csvLine) {

        //Division de una linea del csv en tokens separados entre ";"
        String[] tokens = csvLine.replace("\"", "").split(";", 22);

        return Alojamiento.builder()
                          .withNumRegistro(tokens[0])
                          .withTipo(TipoAlojamiento.getTipoAlojamiento(tokens[1]))
                          .withCategoria(CategoriaAlojamiento.getCategoriaAlojamiento(tokens[2]))
                          .withEspecialidades(tokens[3])
                          .withNombre(tokens[4])
                          .withDireccion(tokens[5])
                          .withCodPostal(tokens[6])
                          .withProvincia(Provincia.getProvincia(tokens[7]))
                          .withMunicipio(tokens[8])
                          .withNucleo(tokens[9])
                          .withLocalidad(tokens[10])
                          .withTelefonos(getListaTelefonos(List.of(tokens[11], tokens[12], tokens[13])))
                          .withEmail(tokens[14])
                          .withWeb(tokens[15])
                          .withCalidadQ(tokens[16])
                          .withCentralReservas(tokens[17])
                          .withPlazas(Integer.parseInt(tokens[18].replaceFirst("", "0")))
                          .withLatitud(tokens[19])
                          .withLongitud(tokens[20])
                          .withAccMinusvalidos(tokens[21].equals("Si"))
                          .build();
    }

}
