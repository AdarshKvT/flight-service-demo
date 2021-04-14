package com.kvtsoft.flightservicedemo.utils;

import com.kvtsoft.flightservicedemo.exception.InsufficientAmountException;
import com.kvtsoft.flightservicedemo.service.FlightBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static Logger log = LoggerFactory.getLogger(PaymentUtils.class);

    static Map<String, Double> paymentMap = new HashMap<>();

    // customers bank account details in static block
    static {
        paymentMap.put("acc1", 1200.0);
        paymentMap.put("acc2", 18880.00);
        paymentMap.put("acc3", 15000.23);
        paymentMap.put("acc4", 5000.00);
    }

    public static boolean validateCreditLimit(String accNo, Double flightFare) {
        log.info("accNo: "+paymentMap.get(accNo)+" flightFare: " +flightFare);
        if (flightFare > paymentMap.get(accNo)) {
            log.info("inside flightFare > paymentMap.get(accNo)");
            throw new InsufficientAmountException("Insufficient bank balance..!!");
        } else {
            return true;
        }
    }
}
