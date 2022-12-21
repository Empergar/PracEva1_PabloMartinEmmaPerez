package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Alojamiento.AlojamientoJsonAdapter;
import es.upsa.sbd2.Alojamiento.CsvParserAlojamientos;
import es.upsa.sbd2.Enumeraciones.TipoAlojamiento;
import es.upsa.sbd2.Restaurante.CsvParserRestaurante;
import es.upsa.sbd2.Restaurante.RestauranteJsonAdapter;
import es.upsa.sbd2.Restaurante.Restaurante;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//<----------------------------------->//
//    -*-Pablo Martin Sanchez-*-       //
//     -*-Emma Perez Garcia-*-         //
// -> Sistemas de Bases de Datos II <- //
//             2022/2023               //
//<----------------------------------->//
public class Main {
    public static void main(String[] args) throws IOException {

        Data data= new Data();
        //<----------------------------------->//
        //              -*-Main-*-             //
        //<----------------------------------->//

        //Ficheros necesarios para los alojamientos:
        File csvFile1 = new File("alojamientos.csv");
        File alojamientosjsonFile = new File("alojamientos.json");

        //Ficheros necesarios para los restaurantes:
        File csvFile2 = new File("restaurantes.csv");
        File restaurantesjsonFile = new File("restaurantes.json");

        //Creamos los ficheros Json con la estructura indicada por el enunciado en el apartado Main
        createAlojamientosJson(alojamientosjsonFile, csvFile1);
        createRestaurantesJson(restaurantesjsonFile, csvFile2);


        //<----------------------------------->//
        //      -*-Data y Predicates-*-        //
        //<----------------------------------->//

        //Carga de datos de los alojamientos en memoria (Clase Data)
        data.loadAlojamientos(alojamientosjsonFile);
        data.loadRestaurantes(restaurantesjsonFile);

        //Creacion de los ficheros y llamada a la funcion saveAlojamiento
        File file1 = new File("AlojamientosByCodigoPostal37001AndTipoHostal.json");
        //data.saveAlojamientos(Predicates.alojamientosByCodigoPostal("37001")
                //.and(Predicates.alojamientosByTipo(TipoAlojamiento.HOSTAL)), file1);

        File file2 = new File("AlojamientosByCodigoPostal37700.json");
        //data.saveAlojamientos(Predicates.alojamientosByCodigoPostal("37700"), file2);

        File file3 = new File("AlojamientosByCodigoPostal37210.json");
        //data.saveAlojamientos(Predicates.alojamientosByCodigoPostal("37210"),file3);

        //Creacion de la lista y llamada a la funcion filterRestaurantes
        List<Restaurante> restaurantesByLocalidadBejar = data.filterRestaurantes(Predicates.restaurantesByLocalidad("bejar"));
        //restaurantesByLocalidadBejar.forEach(System.out::println);
        // for (Restaurante rest: restaurantesByLocalidadBejar)
        // {
        //   System.out.println(rest.getNombre() + "\t" + rest.getLocalidad());
        // }

        List<Restaurante> restaurantesByLocalidadVitigudino = data.filterRestaurantes(Predicates.restaurantesByLocalidad("vitigudino"));
        restaurantesByLocalidadVitigudino.forEach(System.out::println);


    }

    //<----------------------------------------------->//
    //     Obtener fichero Json de alojamientos        //
    //<----------------------------------------------->//

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

    //<----------------------------------------------->//
    //     Obtener fichero Json de restaurantes        //
    //<----------------------------------------------->//
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
