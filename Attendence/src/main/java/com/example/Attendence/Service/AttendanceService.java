package com.example.Attendence.Service;

import com.example.Attendence.Models.Attendance;

public interface AttendanceService {
    String generate(String empCode) throws Exception;

    Attendance get(String empCode)throws Exception;
}
