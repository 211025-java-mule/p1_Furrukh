package com.GlobalCorona.GlobalCoronaApi;

import com.GlobalCorona.GlobalCoronaApi.Boorstrap.DataGetter;
import com.GlobalCorona.GlobalCoronaApi.Controllers.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GlobalCoronaApiApplication {
	private static Logger logger = LoggerFactory.getLogger(GlobalCoronaApiApplication.class);
	public static void main(String[] args) {
		logger.info("Server Started");
		SpringApplication.run(GlobalCoronaApiApplication.class, args);

	}

}
