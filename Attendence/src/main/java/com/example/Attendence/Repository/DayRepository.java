package com.example.Attendence.Repository;

import com.example.Attendence.Models.Day;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Integer> {
    Optional<Day> findDayByAttendanceAttendIdAndDayId(Integer attendId, Integer dayId);
}
