package com.example.Attendence.Service;

import java.util.Date;

public interface DayService {
    String save(Date currentDate, Integer attendId)throws Exception;
}
