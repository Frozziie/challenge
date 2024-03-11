package com.example.eldar.entity;

import com.example.eldar.exception.CardBrandException;
import com.example.eldar.utils.Constants;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;

public enum Brand {

    VISA("visa") {
        @Override
        public Double getFee() {
            LocalDateTime today = LocalDateTime.now();
            return (double) (today.getYear() / today.getMonthValue());
        }
    },
    NARA("naranja") {
        @Override
        public Double getFee() {
            LocalDateTime today = LocalDateTime.now();
            return today.getDayOfMonth() * Constants.NARANJA_FEE;
        }
    },
    AMEX("amex") {
        @Override
        public Double getFee() {
            LocalDateTime today = LocalDateTime.now();
            return today.getMonthValue() * Constants.AMEX_FEE;
        }
    };

    private final String name;

    Brand(String brandName) {
        this.name = brandName;
    }

    @JsonCreator
    public static Brand getBrand(String brandName) {

        if (brandName.isEmpty()) {
            throw new NullPointerException("Card brand cannot be empty");
        }

        for (Brand brand : Brand.values()) {
            if (brand.name.equalsIgnoreCase(brandName)) {
                return brand;
            }
        }
        throw new CardBrandException("Card brand mapping for value " + brandName +
                " not available");
    }

    public abstract Double getFee();
}
