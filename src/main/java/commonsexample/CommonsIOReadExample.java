package commonsexample;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CommonsIOReadExample {
String path="src/main/resources/pyramids.csv";
    public static void main(String args[]) {
CommonsIOReadExample commonsIOReadExample=new CommonsIOReadExample ();
        try {
            commonsIOReadExample.readLines (commonsIOReadExample.path);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void readLines(String path) throws IOException {
        try (InputStream is = new FileInputStream (path)) {
            String content = IOUtils.toString (is, StandardCharsets.UTF_8);
            System.out.println (content);
        }
        try (InputStream is = new FileInputStream (path)) {
            List<String> lines = IOUtils.readLines (is, StandardCharsets.UTF_8);
            System.out.println (lines);
        }
    }
}
