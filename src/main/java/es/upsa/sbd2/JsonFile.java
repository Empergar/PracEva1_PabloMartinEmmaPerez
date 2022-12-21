package es.upsa.sbd2;

import es.upsa.sbd2.Interfaces.JsonAdapter;
import jakarta.json.Json;
import jakarta.json.JsonWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFile <T> {

    //Creamos el adaptador generico de objetos T
    private final JsonAdapter<T> jsonAdapter;

    //Creamos el constructor
    public JsonFile(JsonAdapter<T> jsonAdapter){
        this.jsonAdapter = jsonAdapter;
    }

    //Se crea el metodo write
    public void write(File file, List<T> data) throws IOException{

        //Comenzamos la escritura del fichero .json, siempre dentro de un try porque los flujos son closeables
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw);
             JsonWriter jw = Json.createWriter(bw)){

            //Se escribe
            jw.write( jsonAdapter.toJsonArray(data) );
            //Se limpia el buffer
            bw.flush();
        }
    }
}
