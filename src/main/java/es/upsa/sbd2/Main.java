package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Alojamiento.AlojamientoJsonAdapter;
import es.upsa.sbd2.Alojamiento.CsvParserAlojamientos;
import es.upsa.sbd2.Restaurante.CsvParserRestaurante;
import es.upsa.sbd2.Restaurante.RestauranteJsonAdapter;
import es.upsa.sbd2.Restaurante.Restaurante;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Ficheros necesarios para los alojamientos:
        File csvFile1 = new File("alojamientos.csv");
        File alojamientosjsonFile = new File("alojamientos.json");

        //Ficheros necesarios para los restaurantes:
        //File csvFile2 = new File("restaurantes.csv");
        //File restaurantesjsonFile = new File("restaurantes.json");

        createAlojamientosJson(alojamientosjsonFile, csvFile1);
        //createRestaurantesJson(restaurantesjsonFile, csvFile2);
    }

    //Obtener fichero Json de alojamientos
    public static void createAlojamientosJson(File jsonFile, File csvFile) throws IOException {
        //Creamos CsvParser y su adapter correspondiente
            CsvParserAlojamientos csvParser = new CsvParserAlojamientos();
        JsonAdapter<Alojamiento> jsonAdapter = new AlojamientoJsonAdapter();

        //Creamos el CsvReader genérico
        CsvReader csvReader = new CsvReader();
        //Obtenemos la lista de alojamientos a partir del csv con su CsvReader
        List<Alojamiento> alojamientos = csvReader.read(csvFile,csvParser, "Windows-1252");
        //Convertimos la lista obtenida a un fichero .json
        JsonFile<Alojamiento> jsnFile = new JsonFile<>( jsonAdapter );
        jsnFile.write(jsonFile, alojamientos);
    }

    //Obtener fichero Json de restaurantes
    public static void createRestaurantesJson(File jsonFile, File csvFile) throws IOException {
        //Creamos CsvParser y su adapter correspondiente
        CsvParserRestaurante csvParser = new CsvParserRestaurante();
        JsonAdapter<Restaurante> jsonAdapter = new RestauranteJsonAdapter();

        //Creamos el CsvReader genérico
        CsvReader csvReader = new CsvReader();
        //Obtenemos la lista de restaurantes a partir del csv con su CsvReader
        List<Restaurante> restaurantes = csvReader.read(csvFile, csvParser, "UTF-8");
        //Convertimos la lista obtenida a un fichero .json
        JsonFile<Restaurante> jsnFile = new JsonFile<>( jsonAdapter );
        jsnFile.write(jsonFile, restaurantes);
    }

}
