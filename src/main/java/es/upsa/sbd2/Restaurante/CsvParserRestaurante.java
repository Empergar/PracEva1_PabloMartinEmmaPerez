package es.upsa.sbd2.Restaurante;

import es.upsa.sbd2.CsvParser;
import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
import es.upsa.sbd2.Restaurante.Restaurante;

import java.util.List;

public class CsvParserRestaurante implements CsvParser<Restaurante> {

    @Override
    public Restaurante parse(String csvLine) {

        //Division de una linea del csv en tokens separados entre ";"
        String[] tokens = csvLine.replace("\"", "").split(";", 27);

        return Restaurante.builder()
                          .withEstablecimiento(tokens[0])
                          .withNumRegistro(tokens[1])
                          .withCodigo(tokens[2])
                          .withTipo(tokens[3])
                          .withCategoria(CategoriaRestaurante.getCategoriaRestaurante((tokens[4])))
                          .withClase(tokens[5])
                          .withEspecialidades(tokens[6])
                          .withNombre(tokens[7])
                          .withDireccion(tokens[8])
                          .withCodPostal(tokens[9])
                          .withProvincia(Provincia.getProvincia(tokens[10]))
                          .withMunicipio(tokens[11])
                          .withLocalidad(tokens[12])
                          .withNucleo(tokens[13])
                          .withTelefonos(getListaTelefonos(List.of(tokens[14], tokens[15], tokens[16])))
                          .withEmail(tokens[17])
                          .withWeb(tokens[18])
                          .withCalidadQ(tokens[19])
                          .withCentralReservas(tokens[20])
                          .withPosadaReal(tokens[21])
                          .withPlazas(Integer.parseInt(tokens[22].replaceFirst("", "0")))
                          .withLongitud(tokens[23])
                          .withLatitud(tokens[24])
                          .withAccMinusvalidos(tokens[25])
                          .withPosicion(tokens[26])
                          .build();
    }
}
