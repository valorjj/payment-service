package com.example.paymentservice.entity;


import com.example.paymentservice.common.BaseTime;
import com.example.paymentservice.model.PaymentMode;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.model.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TX_DETAIL_TBL")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class TransactionDetail extends BaseTime {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "tx_id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "REF_NUM")
    private String referenceNumber;

    @Column(name = "mode")
    @Enumerated(STRING)
    private PaymentMode paymentMode;

    @Column(name = "status")
    @Enumerated(STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "AMOUNT")
    private Long amount;

    public TransactionDetail(PaymentRequest paymentRequest) {
        this.orderId = paymentRequest.orderId();
        this.referenceNumber = paymentRequest.referenceNumber();
        this.paymentMode = paymentRequest.paymentMode();
        this.paymentStatus = PaymentStatus.SUCCESS;
        this.amount = paymentRequest.amount();
    }
}
