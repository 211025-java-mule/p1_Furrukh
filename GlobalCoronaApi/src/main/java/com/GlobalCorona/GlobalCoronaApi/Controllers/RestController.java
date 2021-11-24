package com.GlobalCorona.GlobalCoronaApi.Controllers;

import com.GlobalCorona.GlobalCoronaApi.Json.CoronaDataObject;
import com.GlobalCorona.GlobalCoronaApi.Models.CoronaDataModel;
import com.GlobalCorona.GlobalCoronaApi.Repositories.CoronaDataRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/GlobalCorona/")
public class RestController {

    CoronaDataRepo coronaDataRepo;
    String country = "Pakistan";

        public RestController(CoronaDataRepo coronaDataRepo) {
        this.coronaDataRepo = coronaDataRepo;
    }

    @GetMapping(
            path = "/allCountries",
            produces = "application/json"
    )
    public List<CoronaDataModel> getAllCountries(){
        List<CoronaDataModel> allRows = new ArrayList<>();
        allRows = coronaDataRepo.findByCountry(country);
        return allRows;
    }

}
