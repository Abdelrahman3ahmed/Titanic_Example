package guava;

import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GuavaReadExample {
    String path="src/main/resources/pyramids.csv";
    public static void main(String args[]){
        GuavaReadExample guavaReadExample= new GuavaReadExample ();
        try {
            guavaReadExample.readLines (guavaReadExample.path);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public void readLines(String path) throws IOException {
        File file = new File (path);
        CharSource wordsSource = Files.asCharSource(file, StandardCharsets.UTF_8);
        List<String> lines = wordsSource.readLines();
        lines.stream ().forEach (System.out::println);

    }
}
