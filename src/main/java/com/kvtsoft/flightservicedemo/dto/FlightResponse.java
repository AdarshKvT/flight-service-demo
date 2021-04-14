package com.kvtsoft.flightservicedemo.dto;

import com.kvtsoft.flightservicedemo.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightResponse {
    private String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;

}
