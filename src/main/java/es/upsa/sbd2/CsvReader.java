package es.upsa.sbd2;

import es.upsa.sbd2.Interfaces.CsvParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    //Leemos nuestros ficheros .csv
    public <T> List<T> read(File csvFile, CsvParser<T> csvParser, String charset) throws IOException {

        //Creamos la lista que devolverá la función
        List<T> list = new ArrayList<>();

        //Comenzamos la lectura efectiva del fichero, siempre dentro de un try porque son closeables
        try (FileReader fr = new FileReader(csvFile, Charset.forName(charset)); //Para origen
             BufferedReader br = new BufferedReader(fr)){ //Para leer

            //Tenemos que leer la primera linea antes porque no nos interesa
            String csvLine = br.readLine();
            csvLine = br.readLine();

            //Hasta la ultima linea
            while ( csvLine != null ){

                //Convertimos en objeto la linea csv
                T object = csvParser.parse(csvLine);
                //Annadimos el objeto a la lista
                list.add(object);
                //Pasa a la siguiente linea
                csvLine = br.readLine();
            }
        }
        //Devuelve la lista
        return list;
    }

}
