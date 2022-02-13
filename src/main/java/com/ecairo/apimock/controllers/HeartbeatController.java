package com.ecairo.apimock.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class HeartbeatController {

    @GetMapping("/heartbeat")
    public String getHeartbeat(){
        Calendar cal = Calendar.getInstance();
        Date date=cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("d/MM/YYYY HH:mm:ss");
        String formattedDate=dateFormat.format(date);

        return "Heart is beating at " + formattedDate;
    }
}
