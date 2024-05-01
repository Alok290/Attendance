package com.example.Attendence.Controller;


import com.example.Attendence.Service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.Time;

@RestController
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    private EntriesService entriesService;

    @PostMapping("/in")
    public ResponseEntity In(@RequestParam Time timeIn , @RequestParam Integer attendId ,@RequestParam Integer dayId)throws Exception{
        try{
            String response = entriesService.save(timeIn,attendId,dayId);
            return new ResponseEntity(response,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

//
//    @PostMapping("/out")
//    public ResponseEntity out()


}
