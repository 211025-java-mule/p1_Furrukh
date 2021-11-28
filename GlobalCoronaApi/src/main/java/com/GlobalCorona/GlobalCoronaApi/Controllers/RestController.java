package com.GlobalCorona.GlobalCoronaApi.Controllers;
import com.GlobalCorona.GlobalCoronaApi.Boorstrap.DataGetter;
import com.GlobalCorona.GlobalCoronaApi.Json.CoronaDataObject;
import com.GlobalCorona.GlobalCoronaApi.Json.DateSetter;
import com.GlobalCorona.GlobalCoronaApi.Models.CoronaDataModel;
import com.GlobalCorona.GlobalCoronaApi.Repositories.CoronaDataRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/GlobalCorona/")
public class RestController {

    DataGetter dataGetter;
    CoronaDataRepo coronaDataRepo;

        public RestController(CoronaDataRepo coronaDataRepo, DataGetter dataGetter) {
        this.coronaDataRepo = coronaDataRepo;
        this.dataGetter = dataGetter;
    }

    @GetMapping(
            path = "/CountryAndDate",
            produces = "application/json"
    )
    public List<CoronaDataModel> getCountryWithDate(@RequestParam String country,@RequestParam String date){
        List<CoronaDataModel> allRows = new ArrayList<>();
        allRows = coronaDataRepo.findAllByDateAndCountry(country,date);
        return allRows;
    }

    @GetMapping(
            path = "/Country",
            produces = "application/json"
    )
    public List<CoronaDataModel> getCountry(@RequestParam String country){
        List<CoronaDataModel> allRows = new ArrayList<>();
        allRows = coronaDataRepo.findAllByCountry(country);
        return allRows;
    }

    @GetMapping(
            path = "/allCountries",
            produces = "application/json"
    )
    public List<CoronaDataModel> getAllCountriesDate(@RequestParam String date){
        List<CoronaDataModel> allRows = new ArrayList<>();
        allRows = coronaDataRepo.findAllByDate(date);
        return allRows;
    }

    @PostMapping(
            path = "/setDate",
            produces = "application/json"
    )
    public void setDate(@RequestBody String json){
            Gson gson = new Gson();
            DateSetter data = gson.fromJson(json, DateSetter.class);
            this.dataGetter.setDate(data.getDate());
            //List<CoronaDataModel> allRows = new ArrayList<>();
            Integer x = coronaDataRepo.findDate(data.getDate());
            if(x  == 0){
                dataGetter.getData();
            }



    }


}



