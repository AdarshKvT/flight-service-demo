package com.kvtsoft.flightservicedemo.controller;

import com.kvtsoft.flightservicedemo.dto.FlightRequest;
import com.kvtsoft.flightservicedemo.dto.FlightResponse;
import com.kvtsoft.flightservicedemo.service.FlightBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {
    Logger log = LoggerFactory.getLogger(FlightBookingController.class);

    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/book-flight")
    public ResponseEntity<FlightResponse> bookFlight(@RequestBody FlightRequest request) {
        log.info("book-flight object: " +request);
        FlightResponse acknowledgement = flightBookingService.bookFlightTicket(request);

        if (acknowledgement != null) {
            return new ResponseEntity(acknowledgement, HttpStatus.OK);
        } else {
            return new ResponseEntity("Insufficient balance", HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
