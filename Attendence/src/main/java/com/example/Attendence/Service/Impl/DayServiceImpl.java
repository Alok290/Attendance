package com.example.Attendence.Service.Impl;

import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Models.Day;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Repository.DayRepository;
import com.example.Attendence.Service.AttendanceService;
import com.example.Attendence.Service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private DayRepository dayRepository;


    @Override
    public String save(Date currentDate, Integer attendId) throws Exception {

        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendId);

        if(optionalAttendance.isEmpty()){
            throw new RuntimeException("not valid");
        }

        Attendance attendance = optionalAttendance.get();

        Day day = new Day();
        day.setDate(currentDate);
        day.setAttendance(attendance);

        attendance.getDays().add(day);

        attendanceRepository.save(attendance);
        return "saved";
    }
}
