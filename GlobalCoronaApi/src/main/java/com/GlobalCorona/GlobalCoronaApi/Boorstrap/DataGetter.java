package com.GlobalCorona.GlobalCoronaApi.Boorstrap;
import com.GlobalCorona.GlobalCoronaApi.Models.CoronaDataModel;
import com.GlobalCorona.GlobalCoronaApi.Repositories.CoronaDataRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataGetter implements CommandLineRunner {

    public static String date;
    public static String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/";
    private final CoronaDataRepo coronaDataRepo;

    public DataGetter(CoronaDataRepo coronaDataRepo) {
        this.coronaDataRepo = coronaDataRepo;
    }

    private void makeObjects(String data) {
        try{
            StringReader csvBodyReader = new StringReader(data);
            CoronaDataModel obj;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBodyReader);
            for (CSVRecord record : records) {
                date = dateFormat.parse(record.get("Last_Update"));
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                obj = new CoronaDataModel(record.get("Province_State"), record.get("Country_Region"),
                        sqlDate,Float.parseFloat(record.get("Confirmed") != "" ? record.get("Confirmed") : "0.0" ),
                        Float.parseFloat(record.get("Deaths") != "" ? record.get("Deaths") : "0.0"),
                        Float.parseFloat(record.get("Recovered") != "" ? record.get("Recovered") : "0.0")
                        ,Float.parseFloat(record.get("Active") != "" ? record.get("Active") : "0.0"),
                        Float.parseFloat(record.get("Case_Fatality_Ratio") != "" ? record.get("Case_Fatality_Ratio") : "0.0"));
                //System.out.println(obj.toString());
                coronaDataRepo.save(obj);
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
        }

    }

    public void setUrl(String date){
        this.url = this.url + date;
    }

    public void getData(){
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
            HttpResponse<String> httpResponse = client.send(req, HttpResponse.BodyHandlers.ofString());
            String data = httpResponse.body();
            //System.out.println(data);
            makeObjects(data);
        }
        catch(IOException | InterruptedException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run(String... args) throws Exception {
        this.setUrl("10-24-2021.csv");
        this.getData();
    }
}