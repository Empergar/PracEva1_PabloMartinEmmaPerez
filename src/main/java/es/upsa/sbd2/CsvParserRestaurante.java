package es.upsa.sbd2;

public class CsvParserRestaurante implements CsvParser<Restaurante> {


    @Override
    public Restaurante parse(String csvLine) {

        String[] tokens = csvLine.split(";", 27);

        return Restaurante.builder()
                .withEstablecimiento(tokens[0])
                .withNumRegistro(tokens[1])
                .withCodigo(tokens[2])
                .withTipo(tokens[3])
                .withCategoria(tokens[4])
                .withClase(tokens[5])
                .withEspecialidades(tokens[6])
                .withNombre(tokens[7])
                .withDireccion(tokens[8])
                .withCp(tokens[9])
                .withProvincia(tokens[10])
                .withMunicipio(tokens[11])
                .withLocalidad(tokens[12])
                .withNucleo(tokens[13])
                .withTlf1(tokens[14])
                .withTlf2(tokens[15])
                .withTlf3(tokens[16])
                .withEmail(tokens[17])
                .withWeb(tokens[18])
                .withCalidadQ(tokens[19])
                .withCentralReservas(tokens[20])
                .withPosadaReal(tokens[21])
                .withPlazas(tokens[22])
                .withLongitud(tokens[23])
                .withLatitud(tokens[24])
                .withAccesible(tokens[25])
                .withPosicion(tokens[26])
                .newBuilder();
    }
}
