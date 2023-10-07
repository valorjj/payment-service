package com.example.paymentservice.exception;

import com.example.paymentservice.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PaymentServiceCustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PaymentSerivceCustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(PaymentSerivceCustomException e) {
        return ResponseEntity.status(e.getStatus())
            .body(ErrorResponse.builder().errorMessage(e.getMessage()).errorCode(e.getErrorCode()).build());
    }

}
