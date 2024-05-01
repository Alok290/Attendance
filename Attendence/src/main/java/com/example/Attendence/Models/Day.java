package com.example.Attendence.Models;


import com.example.Attendence.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dayId;

    private Date date;

    private Integer totalWorkingHour; //updated from entries


    @Enumerated(value = EnumType.STRING)
    private Status status = Status.AA; //updated from entries

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Attendance attendance;



    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<Entries> entriesList;
}
