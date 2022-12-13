package es.upsa.sbd2;

import es.upsa.sbd2.Restaurante.CsvParserRestaurante;
import es.upsa.sbd2.Restaurante.RestauranteJsonAdapter;
import es.upsa.sbd2.Restaurante.Restaurante;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //Ficheros necesarios para los restaurantes:
        File csvFile = new File("restaurantes.csv");
        File restaurantesjsonFile = new File("restaurantes.json");

        createRestaurantesJson(restaurantesjsonFile, csvFile);
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
