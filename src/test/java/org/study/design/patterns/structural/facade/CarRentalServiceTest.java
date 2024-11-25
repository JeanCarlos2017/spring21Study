package org.study.design.patterns.structural.facade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRentalServiceTest {

    @Test
    void carRental() {
        CarRentalService service = new CarRentalService();
        assertEquals("fusca", service.carRental("SP", "fusca"));
    }
}