package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.AlojamientosWithRestaurantes.AlojamientosWithRestaurantes;
import es.upsa.sbd2.Predicates.Predicates;
import es.upsa.sbd2.Restaurante.Restaurante;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Data
{
    //Listas a nivel de clase para tratar después los objetos que contienen
    private List<Alojamiento> alojamientos = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<>();

    //<-------------------------------------------------------------->//
    //    Carga y almacena en memoria los alojamientos hoteleros      //
    //<-------------------------------------------------------------->//
    public void loadAlojamientos(File jsonFile) throws IOException
    {
        Jsonb jsonb = createJsonb();

        //Recuperamos un LIST de los alojamientos
        try(FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr)){
            alojamientos = jsonb.fromJson(br, new ArrayList<Alojamiento>() {}.getClass().getGenericSuperclass());
        }
    }

    //<-------------------------------------------------------------->//
    //          Carga y almacena en memoria los restaurantes          //
    //<-------------------------------------------------------------->//
    public void loadRestaurantes(File jsonFile) throws IOException
    {
        Jsonb jsonb = createJsonb();

        //Recuperamos un LIST de los restaurantes
        try(FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr)){
            restaurantes = jsonb.fromJson(br, new ArrayList<Restaurante>() {}.getClass().getGenericSuperclass());
        }

    }

    //<------------------------------------------------------------------------------------->//
    //       Seleccion de alojamientos hoteleros que cumplen una determinada condición       //
    //<------------------------------------------------------------------------------------->//
    public void saveAlojamientos(Predicate<Alojamiento> condition, File newJsonFile) throws IOException
    {
        Jsonb jsonb = createJsonb();

        List<Alojamiento> resultadoAlojamientos = alojamientos.stream()
                                                              .filter(condition)
                                                              .collect(Collectors.toList());
        try (FileWriter fw = new FileWriter(newJsonFile);
             BufferedWriter bw = new BufferedWriter(fw))
        {
            jsonb.toJson(resultadoAlojamientos, bw);
            bw.flush();
        }
    }

    //<------------------------------------------------------------------------------------->//
    //           Seleccion de restaurantes que cumplen una determinada condición             //
    //<------------------------------------------------------------------------------------->//
    public List<Restaurante> filterRestaurantes(Predicate<Restaurante> condition)
    {
        return restaurantes.stream()
                           .filter(condition)
                           .collect(Collectors.toList());
    }

    //<--------------------------------------------------------------------------------------------------------------->//
    //     Crea un fichero json en el que se incluirán los alojamientos conteniendo sus restaurantes relacionados.     //
    //<--------------------------------------------------------------------------------------------------------------->//
    public void saveAlojamientosWithRestaurantes(Predicate<Alojamiento> condition, File jsonFile) throws IOException {
        Jsonb jsonb = createJsonb();

        List<AlojamientosWithRestaurantes> alojamientosWithRest = new ArrayList<>();
        List<Alojamiento> resultadoAlojamientos = alojamientos.stream()
                                                              .filter(condition)
                                                              .collect(Collectors.toList());

        for (Alojamiento aloj: resultadoAlojamientos)
        {
            List<Restaurante> restaurantesAlojamiento = filterRestaurantes(Predicates.restaurantesByAlojamiento(aloj));
            alojamientosWithRest.add(AlojamientosWithRestaurantes.builder()
                                                                 .withAlojamiento(aloj)
                                                                 .withRestaurantes(restaurantesAlojamiento)
                                                                 .build());
        }

        try (FileWriter fw = new FileWriter(jsonFile);
             BufferedWriter bw = new BufferedWriter(fw))
        {
            jsonb.toJson(alojamientosWithRest, bw);
            bw.flush();
        }
    }


    public static Jsonb createJsonb()
    {
        return JsonbBuilder.newBuilder()
                           .build();
    }
}
