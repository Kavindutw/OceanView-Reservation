package com.example.oceanviewreservation.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {

    public static List<String> validateReservationNo(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.trim().isEmpty()) errors.add("Reservation number is required.");
        if (value != null && value.length() > 30) errors.add("Reservation number must be <= 30 characters.");
        return errors;
    }

    public static List<String> validateGuestName(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.trim().isEmpty()) errors.add("Guest name is required.");
        if (value != null && value.length() > 100) errors.add("Guest name must be <= 100 characters.");
        return errors;
    }

    public static List<String> validateContact(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.trim().isEmpty()) errors.add("Contact number is required.");
        if (value != null && value.length() > 30) errors.add("Contact number must be <= 30 characters.");
        return errors;
    }

    public static List<String> validateAddress(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.trim().isEmpty()) errors.add("Address is required.");
        if (value != null && value.length() > 255) errors.add("Address must be <= 255 characters.");
        return errors;
    }
}