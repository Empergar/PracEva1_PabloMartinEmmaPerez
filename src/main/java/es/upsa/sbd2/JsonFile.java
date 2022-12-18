package es.upsa.sbd2;

import jakarta.json.Json;
import jakarta.json.JsonWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFile <T> {

    private JsonAdapter<T> jsonAdapter;

    public JsonFile(JsonAdapter<T> jsonAdapter){
        this.jsonAdapter = jsonAdapter;
    }

    public void write(File file, List<T> data) throws IOException{

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw);
             JsonWriter jw = Json.createWriter(bw)){

            jw.write( jsonAdapter.toJsonArray(data) );
            bw.flush();
        }
    }
}
