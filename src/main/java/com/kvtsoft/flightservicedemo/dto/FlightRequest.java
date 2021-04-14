package com.kvtsoft.flightservicedemo.dto;

import com.kvtsoft.flightservicedemo.entity.PassengerInfo;
import com.kvtsoft.flightservicedemo.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
