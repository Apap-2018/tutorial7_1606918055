package com.apap.tutorial7.controller;

import com.apap.tutorial7.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AirportController {

    @Autowired
    private RestTemplate restTemp;

    @Bean
    public RestTemplate restTemp() {
        return new RestTemplate();
    }

    @GetMapping("/airports")
    public String getAllIndoensianAirportById(@RequestParam(value = "city", required = false) String city) throws Exception {
        return restTemp
                .getForEntity(Setting.getAirportIDUrlByCity(city), String.class)
                .getBody();
    }
}
