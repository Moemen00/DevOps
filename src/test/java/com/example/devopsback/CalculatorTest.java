package com.example.devopsback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addShouldReturnSum() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void multiplyShouldReturnProduct() {
        assertEquals(6, calculator.multiply(2, 3));
    }
}
