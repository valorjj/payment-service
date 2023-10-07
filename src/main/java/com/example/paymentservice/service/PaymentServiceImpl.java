package com.example.paymentservice.service;

import com.example.paymentservice.entity.TransactionDetail;
import com.example.paymentservice.model.PaymentRequest;
import com.example.paymentservice.model.PaymentResponse;
import com.example.paymentservice.repository.TransactionDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final TransactionDetailRepository transactionDetailRepository;

    @Override
    @Transactional
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("[i] 결제를 시도합니다. ");
        TransactionDetail transactionDetail = new TransactionDetail(paymentRequest);
        TransactionDetail savedTransactionDetail = transactionDetailRepository.save(transactionDetail);
        log.info("[i] 결제가 성공적으로 진행되었습니다.");

        return savedTransactionDetail.getId();
    }

    @Override
    @Transactional
    public PaymentResponse getPaymentDetailsByOrderId(Long orderId) {
        log.info("[i] 주문번호 [{}] 내역 조회를 시도합니다.", orderId);
        TransactionDetail transactionDetailPS = transactionDetailRepository.findByOrderId(orderId);
        log.info("[i] 주문번호 [{}] 내역 조회에 성공했습니다.", orderId);

        log.info("[i] 엔티티를 레코드로 변환합니다. [{}]", PaymentResponse.of(transactionDetailPS));

        return PaymentResponse.of(transactionDetailPS);
    }
}
