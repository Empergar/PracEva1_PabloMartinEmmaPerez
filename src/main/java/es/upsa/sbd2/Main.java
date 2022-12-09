package es.upsa.sbd2;

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

    //Pimera parte del ejercicio
    public static void createRestaurantesJson(File jsonFile, File csvFile) throws IOException {
        CsvParserRestaurante csvParser = new CsvParserRestaurante();
        JsonAdapter<Restaurante> jsonAdapter = new JsonAdapterRestaurantes();

        CsvReader csvReader = new CsvReader();
        List<Restaurante> restaurantes = csvReader.read(csvFile, csvParser);
        JsonFile<Restaurante> jsnFile = new JsonFile<>( jsonAdapter );
        jsnFile.write(jsonFile, restaurantes);
    }
}
