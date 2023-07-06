package com.example.cashcard;

public record CashCard(Long id, Double amount) {
    public CashCard {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }
}
