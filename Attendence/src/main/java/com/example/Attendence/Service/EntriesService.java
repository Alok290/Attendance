package com.example.Attendence.Service;

import java.sql.Time;

public interface EntriesService {

    String save(Time timeIn, Integer attendId, Integer dayId) throws Exception;
}
