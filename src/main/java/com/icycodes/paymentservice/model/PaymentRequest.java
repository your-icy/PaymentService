package com.icycodes.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {


    private String referenceNumber;

    private Long orderId;

    private Long amount;

    private PaymentMode paymentMode;


}
