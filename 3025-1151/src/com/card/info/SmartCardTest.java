package com.card.info;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class SmartCardTest {
    @Test
    void getInstance() throws ParseException {
        SmartCard smartCard = SmartCard.getInstance("LeBron James", "1995-09-22", "2018-5-7", SmartCardNumber.valueOf("LJ-2018-20"));
        System.out.println(smartCard.toString());
        SmartCardNumber.valueOf("LJ-2018-20");
    }

    @Test
    void getStudentName() throws ParseException{
        SmartCard smartCard = SmartCard.getInstance("Kobe Bryant", "1995-09-22", "2018-5-7", SmartCardNumber.valueOf("KB-2018-21"));
        System.out.println(smartCard.getStudentName());
    }

    @Test
    void getDateOfBirth() throws ParseException{
        SmartCard smartCard = SmartCard.getInstance("Kobe Bryant", "1995-09-22", "2018-5-7", SmartCardNumber.valueOf("KB-2018-21"));
        System.out.println(smartCard.getDateOfBirth().toString());
    }

    @Test
    void getSmartCardNumber() throws ParseException{
        SmartCard smartCard = SmartCard.getInstance("Kobe Bryant", "1995-09-22", "2018-5-7", SmartCardNumber.valueOf("KB-2018-21"));
        System.out.println(smartCard.getSmartCardNumber().toString());
    }

    @Test
    void getDateOfIssue() throws ParseException{
        SmartCard smartCard = SmartCard.getInstance("Kobe Bryant", "2002-09-22", "2018-5-7", SmartCardNumber.valueOf("KB-2018-21"));
        System.out.println(smartCard.getDateOfIssue().toString());
    }

}