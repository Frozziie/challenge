package com.example.eldar.utils;

import lombok.SneakyThrows;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Tools {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());

    static {
        symbols.setDecimalSeparator(','); // Coma como separador decimal
        symbols.setGroupingSeparator('.'); // Punto como separador de miles
    }
    private static final NumberFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);

    public static LocalDateTime stringToLocalDateTime(String date) {
        return LocalDateTime.parse(date, formatter);
    }

    @SneakyThrows // Agrego esta anotacion ya que contemplo la Exception en mi GlobalExceptionHandler.
    public static Double formatNumberWithDecimals(Double value) {
        String formattedValue = decimalFormat.format(value);
        return decimalFormat.parse(formattedValue).doubleValue();
    }
}
