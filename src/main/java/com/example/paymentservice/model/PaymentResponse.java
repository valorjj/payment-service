package com.example.paymentservice.model;

import com.example.paymentservice.entity.TransactionDetail;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

@Builder
@JsonNaming(SnakeCaseStrategy.class)
public record PaymentResponse(
    Long paymentId,
    PaymentStatus paymentStatus,
    PaymentMode paymentMode,
    Long amount,
    LocalDateTime paymentDate,
    Long orderId

) {

    public static PaymentResponse of(TransactionDetail tx) {
        return PaymentResponse.builder()
            .paymentId(tx.getId())
            .paymentMode(tx.getPaymentMode())
            .paymentDate(tx.getCreatedDate())
            .paymentStatus(tx.getPaymentStatus())
            .orderId(tx.getOrderId())
            .amount(tx.getAmount())
            .build();
    }

}
