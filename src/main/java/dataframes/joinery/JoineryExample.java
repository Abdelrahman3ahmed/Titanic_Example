package dataframes.joinery;

import com.aol.cyclops.control.LazyReact;
import joinery.DataFrame;
import org.jooq.lambda.tuple.Tuple2;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JoineryExample {
    public static void main(String args[]){
        String path="H:\\ITI AI Matrial\\Java and UML for Machine Learning\\Day2\\Day2\\src\\main\\resources\\persons.csv";
        try {
            DataFrame<Object> df = DataFrame.readCsv(path);
            List<Object> country = df.col("country");
            Map<String, Long> map = LazyReact.sequentialBuilder()
                                             .from(country)
                                             .cast(String.class)
                                             .distinct()
                                             .zipWithIndex()
                                             .toMap(Tuple2::v1, Tuple2::v2);
            map.forEach ((k,v)->System.out.println("Key is "+k+"-----Value is: "+v));
            List<Object> indexes = country.stream().map(map::get).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}
