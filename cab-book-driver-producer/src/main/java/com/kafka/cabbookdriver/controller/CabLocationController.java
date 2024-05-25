package com.kafka.cabbookdriver.controller;


import com.kafka.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity<Map<String, String>> updateLocation() throws InterruptedException {
        int range = 10;

        // Consider this as a random location
        // till this range we are publishing this random value as location
        while (range > 0) {

            //System.out.println(Math.random() + " , " + Math.random());
            cabLocationService.updateLocation(Math.random() + " , " + Math.random());

            // At every second we are going to publish the location data
            Thread.sleep(1000);
            range --;
        }
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
    }

}
