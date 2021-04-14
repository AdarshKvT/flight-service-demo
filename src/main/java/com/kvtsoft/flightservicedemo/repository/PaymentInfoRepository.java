package com.kvtsoft.flightservicedemo.repository;

import com.kvtsoft.flightservicedemo.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
}
