package My_own_handndling;

import joinery.DataFrame;
import tech.tablesaw.api.Table;

import java.io.IOException;


public class Joining_Data {
    public static Joining_Data obj_join = new Joining_Data();
    public static Handeling_Titanic han = new Handeling_Titanic();
    public static void main(String[] args) throws IOException {
        obj_join.retain_dataset();
        Table tab1= obj_join.Read_Merge();
        System.out.println(tab1);
        System.out.println(obj_join.Read_Merge_joinary_version());
        //System.out.println(han.Make_Summary_Stat(tab1));
    }
    public Table Read_Merge() throws IOException {
        String path="src/main/resources/retained_1.csv";
        String path_per="src/main/resources/retained_2.csv";
        Table Titanic_dataset = Table.read().csv(path);
        Table persons_Frame = Table.read().csv(path_per);

        Table merged = Titanic_dataset.
                joinOn("name").inner(persons_Frame);
        return merged;

    }
    public DataFrame<Object> Read_Merge_joinary_version() throws IOException {


        DataFrame<Object> Titanic_Frame =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                        .retain("pclass" , "name" , "sex" , "survived" ,"fare");
        DataFrame<Object> Titanic_Frame2 =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                        .retain("age" , "name" );
        //DataFrame<Object> merged = Titanic_Frame.merge(Titanic_Frame2, DataFrame.JoinType.INNER);
        DataFrame<Object> merged = Titanic_Frame.join(Titanic_Frame2 );
        return merged;

    }
    //DataFrame<Object> df_merged = df_2.merge(df_1, DataFrame.JoinType.INNER);
    public void retain_dataset() throws IOException {

        DataFrame<Object> Titanic_Frame =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                        .retain("pclass" , "name" , "sex" , "survived" ,"fare");
        Titanic_Frame.writeCsv("src/main/resources/retained_1.csv");

        DataFrame<Object> Titanic_Frame2 =
                DataFrame.readCsv("src/main/resources/titanic.csv")
                        .retain("age" , "name" , "ticket" );
        Titanic_Frame2.writeCsv("src/main/resources/retained_2.csv");
    }

}
