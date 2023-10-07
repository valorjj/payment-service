package com.example.paymentservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PaymentSerivceCustomException extends RuntimeException {

    private String errorCode;
    private int status;

    public PaymentSerivceCustomException(String message, String errorCode, int status) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }


}
