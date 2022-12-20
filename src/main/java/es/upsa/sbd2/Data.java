package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import es.upsa.sbd2.Restaurante.Restaurante;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data
{
    private List<Alojamiento> alojamientos = new ArrayList<>();
    private List<Restaurante> restaurantes = new ArrayList<>();

    private Jsonb jsonb= createJsonb();

    public void loadAlojamientos(File jsonFile) throws IOException
    {
        //Recuperamos un ARRAY de los alojamientos
        try(FileReader fr = new FileReader("alojamientos.json");
            BufferedReader br = new BufferedReader(fr)){

            // SE PUEDE SIMPLIFICAR LO DE ARRIBA CON:
            List<Alojamiento> alojamientos = jsonb.fromJson(br, new ArrayList<Alojamiento>() {}.getClass().getGenericSuperclass());

            alojamientos.forEach(System.out::println);
        }


    }

    public void loadRestaurantes(File jsonFile)
    {

    }

    //public void saveAlojamientos(Predicate<Alojamiento> condition, File newJsonFile)
    //{

    //}

    public static Jsonb createJsonb(){
        //Aqui se añaden las configuraciones de como quieres que aparezcan el objeto jsonb
        return JsonbBuilder.newBuilder()
                .build();
    }
}
