package com.example.eldar.controller;

import com.example.eldar.dto.TransactionDTO;
import com.example.eldar.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    public TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Object> getTransactionFee(
            @RequestBody @Valid TransactionDTO dto
            ) {
        return ResponseEntity.ok(
                transactionService.getTransactionFee(dto)
        );
    }
}
