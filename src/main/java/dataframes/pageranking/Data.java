package dataframes.pageranking;

import com.fasterxml.jackson.jr.ob.JSON;
import com.google.common.base.Throwables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    public static List<RankedPage> readRankedPages(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(line -> parseJson(line)).collect(Collectors.toList());
        }
    }

    public static RankedPage parseJson(String line) {
        try {
            return JSON.std.beanFrom(RankedPage.class, line);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }
    }

}
