import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class LotteryResults {
    private Document doc;

    public LotteryResults() {
        try{
            doc = Jsoup.connect("https://www.nlb.lk/results/govisetha").get();
        }
        catch(IOException e){
            System.out.println("Error in constructor : " + e);
        }
    }

    public void printRestults(){
        Elements draws = doc.getElementsByClass("BB");

        for (org.jsoup.nodes.Element draw : draws) {
            System.out.println(draw.text());
        }
    }

    //store the results in a file
    public void storeResults(){
        try{
            FileWriter fileWriter = new FileWriter("README.md");
            Elements draws = doc.getElementsByClass("BB");

            for(int i = 0; i < draws.size(); i++){
                fileWriter.write(  "#### " + (i+1) + "." + draws.get(i).text() + "\n");
            }

            fileWriter.close();
        }
        catch(IOException e){
            System.out.println("Error in storeResults : " + e);
        }


    }


}
