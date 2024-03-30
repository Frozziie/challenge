package com.example.eldar.service;

import com.example.eldar.dto.TransactionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.eldar.utils.Tools.formatNumberWithDecimals;

@Service
@Slf4j
public class TransactionService {

    public TransactionDTO getTransactionFee(TransactionDTO dto) {

        log.info("Request with the following values: {}", dto.toString());

        Double fee = formatNumberWithDecimals(dto.getTransactionAmount() * dto.getCardBrand().getFee());
        dto.setTransactionFee(fee);

        return dto;
    }
}
