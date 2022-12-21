package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Alojamiento.AlojamientoJsonAdapter;
import es.upsa.sbd2.Alojamiento.CsvParserAlojamientos;
import es.upsa.sbd2.Enumeraciones.CategoriaRestaurante;
import es.upsa.sbd2.Enumeraciones.Provincia;
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

        //
        // Carga los alojamientos
        //
                Data data = new Data();
                File alojamientosFile = new File("alojamientos.json");
                File restaurantesFile = new File("restaurantes.json");
                data.loadAlojamientos(alojamientosFile);
                data.loadRestaurantes(restaurantesFile);
        //
        // Crea un fichero con los alojamientos ubicados en el código postal 37001
        //
                File file2 = new File("alojamientosByCodigoPostal37001.json");
                data.saveAlojamientos(Predicates.alojamientosByCodigoPostal("37001"), file2);
        //
        // Crea un fichero con los alojamientos ubicados en el código postal 37001 que disponen de una capacidad mayor
        // que 20 plazas
        //
                File file3 = new File("alojamientosByCodigoPostal37001AndPlazas20.json");
                data.saveAlojamientos(Predicates.alojamientosByCodigoPostal("37001")
                                                .and( Predicates.alojamientosByPlazas(20) ), file3);
        //
        //Crea un fichero con los alojamientos pertenecientes a los códigos postales 37700 o 37210 
        // y que no sean accesibles para minusválidos
        //
                File file1 = new File("AlojamientosByLocalidadBejarOrVitigudinoAndNotAccesible.json");
                data.saveAlojamientos(Predicates.alojamientosByLocalidad("vitigudino")
                                                .or(Predicates.alojamientosByLocalidad("bejar"))
                                                .and(Predicates.alojamientosByAccesibilidadMinusvalidos().negate()), file1);

        //
        // Crea un fichero con todos los alojamientos
        //
                File file4 = new File("allAlojamientos.json");
                data.saveAlojamientos(Predicates.allAlojamientos(), file4);

        //
        // Selecciona los restaurantes ubicados en la provincia de Salamanca
        //
                List<Restaurante> list1= data.filterRestaurantes( Predicates.restaurantesByProvincia(Provincia.SALAMANCA) );
        //
        // Selecciona los restaurantes ubicados de lujo que dispongan de al menos 20 plazas
        //
                List<Restaurante> list2 = data.filterRestaurantes(Predicates.restaurantesByCategoria(CategoriaRestaurante.LUJO)
                                                                            .and( Predicates.restaurantesByPlazas(20) ));

        //
        // Selecciona los alojamientos del tipo Hostal Residencia y muestra sus restaurantes relacionados
        //
        File file5 = new File("AlojamientosWithRestByTipoHostalResidencia.json");
        data.saveAlojamientosWithRestaurantes(Predicates.alojamientosByTipo(TipoAlojamiento.HOSTAL_RESIDENCIA), file5);

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
