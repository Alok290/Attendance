package com.example.Attendence.Service.Impl;

import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;


    @Override
    public String generate(String empCode) throws Exception{

      Attendance attendance = attendanceRepository.findByEmpCode(empCode);




        attendance.setEmpCode(empCode);
        attendanceRepository.save(attendance);
        return "saved";

    }

    @Override
    public Attendance get(String empCode) throws Exception {
      Attendance optionalAttendance = attendanceRepository.findByEmpCode(empCode);

        return optionalAttendance;
    }
}
