package es.upsa.sbd2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public <T> List<T> read(File csvFile, CsvParser<T> csvParser) throws IOException {

        List<T> list = new ArrayList<>();
        try (FileReader fr = new FileReader(csvFile, Charset.forName("UTF-8"));
             BufferedReader br = new BufferedReader(fr)){

            String csvLine = br.readLine();

            csvLine = br.readLine();
            //Hasta la ultima linea
            while ( csvLine != null ){

                T object = csvParser.parse(csvLine);
                list.add(object);
                csvLine = br.readLine();
            }
        }
        return list;
    }

}
