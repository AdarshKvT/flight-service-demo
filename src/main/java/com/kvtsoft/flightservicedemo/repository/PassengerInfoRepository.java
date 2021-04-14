package com.kvtsoft.flightservicedemo.repository;

import com.kvtsoft.flightservicedemo.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
