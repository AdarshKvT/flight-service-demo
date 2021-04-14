package com.kvtsoft.flightservicedemo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passenger_info")
public class PassengerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String name;
    private String email;
    private String source;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yy")
    private Date travelDate;
    private String pickupTime;
    private String arrivalTime;
    private double fare;
}
