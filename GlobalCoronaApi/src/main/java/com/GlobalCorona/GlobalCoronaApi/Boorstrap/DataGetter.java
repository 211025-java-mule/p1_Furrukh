package com.GlobalCorona.GlobalCoronaApi.Boorstrap;
import com.GlobalCorona.GlobalCoronaApi.Models.CoronaDataModel;
import com.GlobalCorona.GlobalCoronaApi.Repositories.CoronaDataRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DataGetter {
    Logger logger = LoggerFactory.getLogger(DataGetter.class);
    public String date;
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
                obj.setDate(this.date);
                coronaDataRepo.save(obj);
                logger.info("CoronaDataObject stored in DB");
            }
        }
        catch(IOException | ParseException e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }

    }


    public void getData(){
        try{
            String tempUrl = this.url;
            System.out.println(this.date);
            tempUrl = tempUrl + this.date + ".csv";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest req = HttpRequest.newBuilder().uri(URI.create(tempUrl)).build();
            HttpResponse<String> httpResponse = client.send(req, HttpResponse.BodyHandlers.ofString());
            String data = httpResponse.body();
            System.out.println(data);
            makeObjects(data);
            logger.info("Request sent to github repo of corona data dump");
        }
        catch(IOException | InterruptedException e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public String getDate() {
        return date;
    }

    public static String getUrl() {
        return url;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
