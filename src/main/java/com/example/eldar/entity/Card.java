package com.example.eldar.entity;

import com.example.eldar.utils.Constants;
import com.example.eldar.utils.Tools;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
public class Card {

    public Card(String cardBrand, Long cardNumber, String cardHolder, String cardDueDate) {
        this.cardBrand = Brand.getBrand(cardBrand);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cardDueDate = Tools.stringToLocalDateTime(cardDueDate);
    }

    private Brand cardBrand;

    private Long cardNumber;

    private String cardHolder;

    private LocalDateTime cardDueDate;

    /* Informacion de tarjeta */
    public String cardInfo() {
        return "Card owner: " + this.cardHolder + "\n" +
                "Card number: " + this.cardNumber + "\n" +
                "Card brand: " + this.cardBrand.name() + "\n" +
                "Card due date: " + this.cardDueDate;
    }

    /* Validar operacion */
    public boolean isValidOperation(Double amount) {
        return amount <= Constants.VALID_OPERATION_AMOUNT;
    }

    /* Validar tarjeta */
    public boolean isValidCard() {
        return this.cardDueDate.isAfter(LocalDateTime.now());
    }

    /* Validar igualdad con tarjeta */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) {
            return false;
        }
        return Objects.equals(this.cardNumber, ((Card) obj).getCardNumber());
    }

    /* Costo de operacion */
    public Double getOperationFee(Double amount) {
        return amount * this.cardBrand.getFee();
    }
}
