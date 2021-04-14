package com.kvtsoft.flightservicedemo.service;

import com.kvtsoft.flightservicedemo.dto.FlightRequest;
import com.kvtsoft.flightservicedemo.dto.FlightResponse;
import com.kvtsoft.flightservicedemo.entity.PassengerInfo;
import com.kvtsoft.flightservicedemo.entity.PaymentInfo;
import com.kvtsoft.flightservicedemo.repository.PassengerInfoRepository;
import com.kvtsoft.flightservicedemo.repository.PaymentInfoRepository;
import com.kvtsoft.flightservicedemo.utils.PaymentUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;

    private static Logger log = LoggerFactory.getLogger(FlightBookingService.class);

    @Transactional
    public FlightResponse bookFlightTicket(FlightRequest request) {
        FlightResponse flightResponse = null;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        log.info("passengerInfo Object: " + passengerInfo);
        passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        log.info("paymentInfo Object: " + paymentInfo);
        paymentInfoRepository.save(paymentInfo);

        String pnrNo = UUID.randomUUID().toString().split("-")[0];
        flightResponse = new FlightResponse("success",passengerInfo.getFare(),pnrNo,passengerInfo);

        return flightResponse;
    }
}
