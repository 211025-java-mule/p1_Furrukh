package com.CoronaGlobalClient.Client.Handler;


import com.CoronaGlobalClient.Client.JsonObjects.CoronaData;
import com.google.gson.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHandler {

    public List<CoronaData> getDataAllCountries(String date){

        try{
            HttpGet httpGet = new HttpGet("http://localhost:8080/GlobalCorona/allCountries");
            HttpClient client = HttpClient.newHttpClient();
            URI uri = new URIBuilder(httpGet.getURI())
                    .addParameter("date", date)
                    .build();
            HttpRequest req = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> httpResponse = client.send(req, HttpResponse.BodyHandlers.ofString());
            String data = httpResponse.body();
            List<CoronaData> listObjects = new ArrayList<CoronaData>();
            JSONArray jsonArray = new JSONArray(data);
            Gson gson = new GsonBuilder().create();
            for(int x = 0;x<jsonArray.length();x++){
                JSONObject obj = jsonArray.getJSONObject(x);
                System.out.println(obj);
                CoronaData cD = gson.fromJson(String.valueOf(obj),CoronaData.class);
                listObjects.add(cD);
            }


            return listObjects;
        }
        catch(IOException | InterruptedException | URISyntaxException | JSONException e){
            e.printStackTrace();
        }
        List<CoronaData> x = new ArrayList<CoronaData>();
        return x;

    }


}
