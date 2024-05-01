package com.example.Attendence.Controller;


import com.example.Attendence.Service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("Days")
public class DayController {

    @Autowired
    private DayService dayService;


    @PostMapping("/saveDay")
    public ResponseEntity save(@RequestParam Date currentDate, Integer attendId) throws Exception{
        String response = dayService.save(currentDate,attendId);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }




}
