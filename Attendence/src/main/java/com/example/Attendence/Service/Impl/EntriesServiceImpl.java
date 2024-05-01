package com.example.Attendence.Service.Impl;

import com.example.Attendence.Enum.Status;
import com.example.Attendence.Exception.AttendanceAlreadyTaken;
import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Models.Day;
import com.example.Attendence.Models.Entries;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Repository.DayRepository;
import com.example.Attendence.Repository.EntriesRepository;
import com.example.Attendence.Service.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Optional;


@Service
public class EntriesServiceImpl implements EntriesService {

   @Autowired
   private EntriesRepository entriesRepository;

   @Autowired
   private AttendanceRepository attendanceRepository;

   @Autowired
   private DayRepository dayRepository;


    @Override
    public String save(Time timeIn, Integer attendId, Integer dayId) throws Exception {
//
//        Optional<Attendance> optionalAttendance = attendanceRepository.findById(attendId);
//
//        if(optionalAttendance.isEmpty()){
//            throw new notPresent("not valid");
//        }
//
//        Attendance attendance = optionalAttendance.get();

        Optional<Day> optionalDay = dayRepository.findDayByAttendanceAttendIdAndDayId(attendId,dayId);

        if(optionalDay.isEmpty()){
            throw new notPresent("not valid");
        }
        Day day = optionalDay.get();

        if(day.getStatus()!= Status.AA){
            throw new RuntimeException("already present");
        }


        Entries entries = new Entries();
        entries.setTimeIn(timeIn);

        entries.setEntryMarked(true);
        entries.setDay(day);

        day.getEntriesList().add(entries);

        dayRepository.save(day);



        return "you are entry marked";




    }
}
