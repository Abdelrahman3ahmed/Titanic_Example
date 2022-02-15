package dataframes.pageranking;

import joinery.DataFrame;

import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String args[]){
    String path="src/main/resources/ranked-pages.json";
        try {
            List<RankedPage> pageList= Data.readRankedPages (path);

            DataFrame<Object> df = BeanToJoinery.convert(pageList, RankedPage.class);
            df = df.retain("bodyContentLength", "titleLength", "numberOfHeaders");
            DataFrame<Object> describe =df.describe ();
            System.out.println(describe.toString());
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
