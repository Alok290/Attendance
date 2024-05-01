package com.example.Attendence.Controller;


import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Service.AttendanceService;
import com.example.Attendence.Service.EntriesService;
import lombok.experimental.PackagePrivate;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.CertPathValidatorException;

@RestController
@RequestMapping("attendance")
public class AttendanceController {


    @Autowired
    private AttendanceService attendanceService;



    @PostMapping("/generate/empCode")
    public String  generate(@PathVariable String empCode) throws Exception{
        try{
          return attendanceService.generate(empCode);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/get/{empCode}")
    public ResponseEntity get(@PathVariable String empCode)throws Exception {
        try {
            Attendance attendance = attendanceService.get(empCode);
            return new ResponseEntity(attendance, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}



