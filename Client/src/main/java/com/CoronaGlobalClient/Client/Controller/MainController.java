package com.CoronaGlobalClient.Client.Controller;

import com.CoronaGlobalClient.Client.Handler.DataHandler;
import com.CoronaGlobalClient.Client.JsonObjects.CoronaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Main")
public class MainController {

    @GetMapping(
            path = "/data",
            produces = "application/json"
    )
    public List<CoronaData> getData(@RequestParam String date){
        DataHandler dataHandler = new DataHandler();
        return dataHandler.getDataAllCountries(date);
    }
    public List<CoronaData> getData(@RequestParam String date, @RequestParam String country){
        DataHandler dataHandler = new DataHandler();
        return dataHandler.getDataAllCountries(date);
    }


}
