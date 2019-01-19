package com.card.info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartCardNumberTest {
    @Test
    void getInstance() {
        SmartCardNumber smartCardNumber = SmartCardNumber.getInstance("LeBron", "James", "2018", "20");
        System.out.println(smartCardNumber.toString());
        SmartCardNumber smartCardNumber1 = SmartCardNumber.valueOf("LJ-2018-20");
    }

    @Test
    void valueOf() {
        SmartCardNumber smartCardNumber = SmartCardNumber.valueOf("LJ-2018-20");
        System.out.println(smartCardNumber.toString());
    }

}