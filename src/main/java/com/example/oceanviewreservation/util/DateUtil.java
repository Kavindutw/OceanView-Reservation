package com.example.oceanviewreservation.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    public static long nights(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null) return 0;
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }
}
