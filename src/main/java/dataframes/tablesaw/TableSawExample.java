package dataframes.tablesaw;

import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TableSawExample {
    Table titanicData;
    String path="src/main/resources/titanic.csv";
    public static void main(String[] args) {
        TableSawExample tda = new TableSawExample ();
        try {
            tda.titanicData = tda.loadDataFromCSV (tda.path);
            //getting the Structure of the data
            String structure = tda.getDataInfoStructure (tda.titanicData);
            System.out.println (structure);
            //getting Data summery
            System.in.read ();
            String summary = tda.getDataSummary (tda.titanicData);
            System.out.println (summary);
            System.in.read ();
            // Adding date Column
            Table dataWithDate = tda.addDateColumnToData (tda.titanicData);
            System.out.println ("=====================================================================================");
            System.out.println (dataWithDate.structure ());
            System.in.read ();
            //Sorting on the added Date Field
            Table sortedData = dataWithDate.sortAscendingOn ("Fake Date");

            //getting the first 10 rows
            System.out.println ("Printing the first rows of the table");
            System.in.read ();
            Table firstTenRows = sortedData.first (50);

            System.out.println (firstTenRows);
            System.in.read ();
            ////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Table mappedData = tda.mapTextColumnToNumber (tda.titanicData);
            Table firstFiveRows = mappedData.first (5);
            System.out.println ("=====================================================================================");
            System.out.println (firstFiveRows);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    //=================================================================================================//
    public Table loadDataFromCSV(String path) throws IOException {
        Table titanicData=Table.read().csv(path);
        return titanicData;
    }
    public String getDataInfoStructure(Table data){
        Table dataStructure=   data.structure();
        return dataStructure.toString();
    }
    public String getDataSummary(Table data){
        Table summary = data.summary ();
        return summary.toString();
    }
    public Table addDateColumnToData(Table data){
        int rowCount=data.rowCount ();
        List<LocalDate> dateList=new ArrayList<LocalDate> ();
        for(int i=0;i<rowCount;i++) {
            dateList.add (LocalDate.of (2021, 3, i%31==0?1:i%31));   }
        DateColumn dateColumn= DateColumn.create("Fake Date",dateList);
        data.insertColumn (data.columnCount (),dateColumn);
        return data;
    }
    public Table mapTextColumnToNumber(Table data){
        DoubleColumn mappedGenderColumn=null;
        StringColumn gender= (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues=new ArrayList<Number>();
        for(String v:gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }  mappedGenderColumn= DoubleColumn.create("gender",mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;
    }
}

