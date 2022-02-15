package My_own_handndling;//import tech.tablesaw.api.DateColumn;
//import tech.tablesaw.api.DoubleColumn;
//import tech.tablesaw.api.StringColumn;
//import tech.tablesaw.api.Table;
//
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;


import tech.tablesaw.api.Table;

import java.io.IOException;

public class Handeling_Titanic {
    static Handeling_Titanic Handele_obj = new Handeling_Titanic();
    public static void main(String[] args) throws IOException {
        //Handele_obj.Handle();
        //Handele_obj.Handlecolumn(0,1);
        Handele_obj.Get_fist_elments(1, 5);
        Handele_obj.Get_Last_elments(1, 5);
        Handele_obj.Get_unique_column(2);
        Handele_obj.Count_Missing_val(2);
        Handele_obj.Get_Type(3);

    }
    public void Handle() throws IOException {

        System.out.println(Handele_obj.Make_Summary_Stat(Handele_obj.Read_Titanic()));
    }
    public Table Read_Titanic() throws IOException {
        String path="src/main/resources/titanic.csv";
        Table Titanic_dataset = Table.read().csv(path);
        return Titanic_dataset;

    }
    public String Make_Summary_Stat(Table dataset)
    {
        return dataset.summary().toString();
    }

    public Table Remove_missingvalues_columns() throws IOException {
            Table Titanic_dataset = Read_Titanic();
            return Titanic_dataset.removeColumnsWithMissingValues();
    }

    public void Handlecolumn (int Column , int val) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        Titanic_dataset.column(Column).setMissing(val).forEach(i->System.out.println(i));
    }
    public void Get_fist_elments (int Column , int val) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        Titanic_dataset.column(Column).first(val).forEach(i->System.out.println(i));
    }
    public void Get_Last_elments (int Column , int val) throws IOException {
        Table Titanic_dataset = Read_Titanic();;
        Titanic_dataset.column(Column).last(val).forEach(i->System.out.println(i));
    }
    public void Get_unique_column (int Column ) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        Titanic_dataset.column(Column).unique().forEach(i->System.out.println(i));
    }
    public void Count_unique_val (int Column ) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        System.out.println(Titanic_dataset.column(Column).countUnique());
    }
    public void Count_Missing_val (int Column ) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        System.out.println(Titanic_dataset.column(Column).countMissing());
    }
    public void remve_missing_on_col (int Column) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        Titanic_dataset.column(Column).removeMissing().forEach(i->System.out.println(i));
    }
    public void Get_Type (int Column ) throws IOException {
        Table Titanic_dataset = Read_Titanic();
        System.out.println(Titanic_dataset.column(Column).type());
    }


}
