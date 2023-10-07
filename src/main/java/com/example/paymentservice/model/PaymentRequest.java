package com.example.paymentservice.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;

import static com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;

@Builder
@JsonNaming(SnakeCaseStrategy.class)
public record PaymentRequest(
    Long orderId,
    Long amount,
    String referenceNumber,
    PaymentMode paymentMode

) {

}
