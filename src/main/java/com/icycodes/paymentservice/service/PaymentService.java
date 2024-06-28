package com.icycodes.paymentservice.service;

import com.icycodes.paymentservice.model.PaymentRequest;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
