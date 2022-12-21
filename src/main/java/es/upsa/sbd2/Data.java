package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Restaurante.Restaurante;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Data
{
    private List<Alojamiento> alojamientos = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<>();

    public void loadAlojamientos(File jsonFile) throws IOException
    {
        Jsonb jsonb = createJsonb();

        //Recuperamos un LIST de los alojamientos
        try(FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr)){

            alojamientos = jsonb.fromJson(br, new ArrayList<Alojamiento>() {}.getClass().getGenericSuperclass());
        }
    }

    public void loadRestaurantes(File jsonFile) throws IOException {
        Jsonb jsonb = createJsonb();

        //Recuperamos un LIST de los restaurantes
        try(FileReader fr = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fr)){

            restaurantes = jsonb.fromJson(br, new ArrayList<Restaurante>() {}.getClass().getGenericSuperclass());
        }

    }

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

    public List<Restaurante> filterRestaurantes(Predicate<Restaurante> condition)
    {
        return restaurantes.stream()
                           .filter(condition)
                           .collect(Collectors.toList());
    }

    public void saveAlojamientosWithRestaurantes(Predicate<Alojamiento> condition, File jsonFile)
    {

    }


    public static Jsonb createJsonb(){
        //Aqui se añaden las configuraciones de como quieres que aparezcan el objeto jsonb
        return JsonbBuilder.newBuilder()
                           .build();
    }
}
