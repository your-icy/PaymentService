package com.icycodes.paymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static jakarta.persistence.GenerationType.TABLE;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetails {


    @TableGenerator(
            name = "paymentGen",
            table = "PAYMENT_ID_GEN",
            pkColumnName = "GEN_KEY",
            valueColumnName = "GEN_VALUE",
            pkColumnValue = "PAYMENT_ID",
            allocationSize = 1)
    @Id
    @GeneratedValue(strategy=TABLE, generator="paymentGen")
    private Long paymentId;

    @Column(name = "ORDER_ID")
    private Long orderId;

    @Column(name = "PAYMENT_MODE")
    private String paymentMode;

    @Column(name = "REFERENCE_NUMBER")
    private String referenceNumber;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name = "PAYMENT_DATE")
    private Instant paymentDate;

    @Column(name = "AMOUNT")
    private Long amount;

}
