package com.example.eldar;

import java.util.Arrays;

public class ExerciseFive {

    public static void main(String[] args) {

        String[] array = {"FirstWord", "SecondWord", "THIRDWORD"};
        String value = String.join(" ", array).toLowerCase();
        System.out.println("Array: " + Arrays.toString(array) + " converted to String: " + value);
    }
}
