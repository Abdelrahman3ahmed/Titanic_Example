package dataframes.joinery;

import joinery.DataFrame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JoineryExample2 {
    public static void main(String args[]) {
        try {
            DataFrame<Object> df1 = DataFrame.readCsv ("src/main/resources/vgsales.csv")
                    .retain ("Year", "NA_Sales", "EU_Sales", "JP_Sales")
                    .describe ();
            System.out.println (df1.toString ());
            System.out.println ("=========================================================================================");
            System.in.read ();
            DataFrame<Object> df = DataFrame.readCsv ("src/main/resources/vgsales.csv")
                    .retain ("Year", "NA_Sales", "EU_Sales", "JP_Sales")
                    .groupBy (x -> x.get (0))
                    .mean ();
            /////////////////////////////////////////////////////////////////////////////////
            System.out.println (df.toString ());
            System.out.println ("================================adding column to data frame=========================================================");
            DataFrame<Object> df2 = DataFrame.readCsv ("src/main/resources/titanic.csv")
                    .retain ("pclass", "survived", "name", "sex", "age");

            List<Integer> newValues = new ArrayList<> ();


            List<Object> values = df2.col ("sex");
            for (Object obj : values) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str != null && str.equals ("female"))
                        newValues.add (1);
                    else
                        newValues.add (0);
                }
            }

            //df2.add ("Gender",newValues);
            df2.add("hi",newValues.stream().toList());

            System.out.println (df2.head (10));
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

