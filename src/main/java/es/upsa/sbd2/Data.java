package es.upsa.sbd2;

import es.upsa.sbd2.Alojamiento.Alojamiento;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.*;

public class Data {

    public void loadAlojamientos(File jsonFile) throws IOException {

        Jsonb jsonb= createJsonb();

        //Recuperamos un ARRAY de los alojamientos

        try(FileReader fr= new FileReader("alojamientos.json");
            BufferedReader br= new BufferedReader(fr)){

            //Hacemos un array de objetos Alojamiento obtenidos por medio de Jsonb
            Alojamiento[] alojamientos = jsonb.fromJson(br, Alojamiento[].class);

            //Como prueba se pueden mostrar en pantalla
            for (Alojamiento alojamiento: alojamientos) {
                System.out.println(alojamiento);
            }

            // SE PUEDE SIMPLIFICAR LO DE ARRIBA CON:
            // ArrayList<Alojamiento> alojamientos=jsonb.fromJson(br, new ArrayList<Alojamiento>() {}.getClass().getGenericSuperclass());
            // alojamientos.forEach(System.out::println);
            // jsonb.fromJson(br,new ArrayList<Alojamiento>() {}.getClass().getGenericSuperclass());
        }


    }
    public static Jsonb createJsonb(){
        //Aqui se añaden las configuraciones de como quieres que aparezcan el objeto jsonb
        return JsonbBuilder.newBuilder()
                .build();
    }
}
