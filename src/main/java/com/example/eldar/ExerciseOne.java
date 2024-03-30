package com.example.eldar;

import com.example.eldar.entity.Card;

import static com.example.eldar.utils.Constants.*;

public class ExerciseOne {

    public static void main(String[] args) {

        Card card1 = new Card("VISA", 4509953566233704L,
                "Leonardo Bravo", "2025-01-28T12:30:00");
        Card card2 = new Card("NARANJA", 5031755734530604L,
                "Maximiliano Bravo", "2028-11-04T20:30:00");
        Card card3 = new Card("AMEX", 4509953566233704L,
                "Lucia Wlozovicz", "2024-01-10T07:45:00");

        /* First card */
        executePrints(card1, card2);

        /* Second card */
        executePrints(card2, card3);

        /* Third card */
        executePrints(card3, card1);
    }

    private static void executePrints(Card card, Card secondCard) {

        System.out.println(card.cardInfo());
        System.out.println(VALID_OPERATION + card.isValidOperation(1000.0));
        System.out.println(VALID_CARD + card.isValidCard());

        if (card.equals(secondCard)) {
            System.out.println("Card is equal to " + secondCard.getCardHolder() + "'s card");
        } else {
            System.out.println("Card is not equal to " + secondCard.getCardHolder() + "'s card");
        }

        System.out.println(CARD_FEE + card.getOperationFee(100.0));

        System.out.println(" ");
    }
}
