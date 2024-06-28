package com.icycodes.paymentservice.service;

import com.icycodes.paymentservice.entity.PaymentDetails;
import com.icycodes.paymentservice.entity.PaymentRepository;
import com.icycodes.paymentservice.model.PaymentRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .orderId(paymentRequest.getOrderId())
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .paymentStatus("SUCCESS")
                .build();


        paymentRepository.save(paymentDetails);
        log.info(":{} payment is created with id", paymentDetails.getPaymentId());

        log.info("payment updated in database");
        return paymentDetails.getPaymentId();

    }
}
