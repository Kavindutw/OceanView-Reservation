package com.example.oceanviewreservation.service;

import java.math.BigDecimal;

public interface BillingService {
    BigDecimal calculateTotal(String reservationNo);
}
