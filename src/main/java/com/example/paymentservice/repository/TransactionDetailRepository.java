package com.example.paymentservice.repository;

import com.example.paymentservice.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

    TransactionDetail findByOrderId(Long orderId);

}
