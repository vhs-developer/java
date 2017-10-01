
package io_streams;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSON {
    public static void main(String[] args) throws Exception {
        List<Integer> zahlen = Arrays.asList(new Integer[] {5, 7, 42, 4711, 0});

        // Gson für Export nutzen:
        Gson gson = new Gson();
        String jsonStr = gson.toJson(zahlen);
        System.out.println(jsonStr);
        
        // json-String in Datei schreiben
        PrintWriter w = new PrintWriter("ausgabe.json");
        w.write(jsonStr);
        w.close();
        // json-String aus Datei lesen
        BufferedReader r = new BufferedReader(new FileReader("ausgabe.json"));
        jsonStr = r.readLine();
        r.close();

        // Gson für Import nutzen:       
        List<Integer> gelesen = gson.fromJson(jsonStr, ArrayList.class);
        System.out.println(gelesen); // TODO: double-Werte
        
    }
    
}
