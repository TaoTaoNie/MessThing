package com.student.info;

import org.junit.jupiter.api.Test;

class StudentIDTest {
    @Test
    void getInstance() {
        StudentID id = StudentID.getInstance("a", "1432");
        System.out.println(id.toString());
    }

    @Test
    void valueOf() {
        StudentID id = StudentID.valueOf("a1234");
        System.out.println(id.toString());
    }

    @Test
    void getSingleLetter() {
        StudentID id = StudentID.valueOf("a1234");
        System.out.println(id.getSingleLetter());
    }

    @Test
    void getDigitNumber() {
        StudentID id = StudentID.valueOf("a1234");
        System.out.println(id.getDigitNumber());
    }


}