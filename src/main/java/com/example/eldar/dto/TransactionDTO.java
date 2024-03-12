package com.example.eldar.dto;

import com.example.eldar.entity.Brand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionDTO {

    @NotNull(message = "Card brand cannot be null or empty")
    private Brand cardBrand;

    @NotNull(message = "Transaction amount cannot be null")
    @Min(value = 1, message = "Transaction amount must be greater than 0")
    private Double transactionAmount;

    private Double transactionFee;
}

