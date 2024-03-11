package com.example.eldar.service;

import com.example.eldar.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionService {

    public TransactionDTO getTransactionFee(TransactionDTO dto) {

        log.info("Request with the following values: {}", dto.toString());

        dto.setTransactionFee(dto.getTransactionAmount() * dto.getCardBrand().getFee());
        return dto;
    }
}
