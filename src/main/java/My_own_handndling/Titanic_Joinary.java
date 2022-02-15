package My_own_handndling;

import joinery.DataFrame;
import tech.tablesaw.api.DoubleColumn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Titanic_Joinary {
    static Titanic_Joinary ob = new Titanic_Joinary();
    public static void main(String[]  args) throws IOException {
        String data = "src/main/resources/titanic.csv";
        try {
            ob.Read_titac_and_make_Stat();
            ob.Grouped_by_age_stat();
            ob.Get_head(data);
            ob.Nonnumeric(data);
            ob.Nonnull(data);
            ob.Drop_columns(data , "name");
            ob.Replace_categorical(data);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
    public void Read_titac_and_make_Stat() throws IOException {

        DataFrame<Object> Titanic_Frame =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                   .retain("pclass" , "age" , "sex" , "survived" ,"fare")
                   .describe();
        System.out.println(Titanic_Frame.toString());


    }
    public void Grouped_by_age_stat() throws IOException {

        DataFrame<Object> Titanic_Frame =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                        .retain("pclass" , "age" , "sex" , "survived" ,"fare")
                        .groupBy("age")
                        .describe().head();
        System.out.println(Titanic_Frame.toString());


    }
    public void Get_head(String data) throws IOException {
        System.out.println(DataFrame.readCsv(data).head());
    }
    public void Print_columns(String data ,String[] columns) throws IOException {
        System.out.println(DataFrame.readCsv(data).retain(columns[0]));
    }
    public void Nonnull(String data) throws IOException {
        System.out.println(DataFrame.readCsv(data).notnull());
    }
    public void Nonnumeric(String data) throws IOException {
        System.out.println(DataFrame.readCsv(data).nonnumeric());
    }
    public void Drop_columns(String data ,String col) throws IOException {
        System.out.println(DataFrame.readCsv(data).drop(col));
    }
    public void Replace_categorical(String data) throws IOException {
        DataFrame<Object> df2 = DataFrame.readCsv ("src/main/resources/titanic.csv")
                .retain ("survived", "name", "sex", "age");
        List<Integer> Numrical_values = new ArrayList<>();
        List<Object> Catigo = df2.col ("sex");
        for (Object obj : Catigo) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str != null && str.equals ("female"))
                    Numrical_values.add (1);
                else
                    Numrical_values.add (0);
            }
        }

        df2.add("Gender" , Numrical_values);
        System.out.println(df2.head());
    }


}
