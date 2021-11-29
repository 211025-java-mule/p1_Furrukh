package com.CoronaGlobalClient.Client.Controller;

import com.CoronaGlobalClient.Client.Handler.DataHandler;
import com.CoronaGlobalClient.Client.JsonObjects.CoronaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RestController
@RequestMapping("/Home")
public class MainController {
    @PostMapping(
            path = "/data",
            produces = "application/json"
    )
    public List<CoronaData> getData(@RequestParam String date) throws ParseException {
        DataHandler dataHandler = new DataHandler();
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MM-dd-yyyy");
        String reformattedStr = myFormat.format(fromUser.parse(date));

        return dataHandler.getDataAllCountries(reformattedStr);
    }
    @PostMapping(
            path = "countryData",
            produces = "application/json"
    )
    public List<CoronaData> getData(@RequestParam String date, @RequestParam String country) throws ParseException {
        DataHandler dataHandler = new DataHandler();
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MM-dd-yyyy");
        String reformattedStr = myFormat.format(fromUser.parse(date));
        System.out.println(date +  " " + country);
        return dataHandler.getSingleCountry(reformattedStr,country);
    }


}
