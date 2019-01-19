package com.student.info;

import com.card.info.SmartCardNumber;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class UndergraduateStudentTest {
    @Test
    void getInstance() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        System.out.println(undergraduateStudent.toString());
    }

    @Test
    void registerModule() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        undergraduateStudent.registerModule("Network", "1434213874", 20);
        System.out.println(undergraduateStudent.getModules());
    }

    @Test
    void setPassMark() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        undergraduateStudent.setPassMark(0.9);
        System.out.println(undergraduateStudent.getPassMark());
    }

    @Test
    void getCredits() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        undergraduateStudent.registerModule("Network1", "1434213874", 20);
        undergraduateStudent.registerModule("Network2", "2341234123", 20);
        System.out.println(undergraduateStudent.getCredits());
    }

    @Test
    void setSmartCard() throws ParseException{
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        undergraduateStudent.setSmartCard("LeBron James", "1992-09-04", "2018-05-07", SmartCardNumber.valueOf("LJ-2018-98"));
        System.out.println(undergraduateStudent.smartCard);
    }

    @Test
    void getStudentID() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        System.out.println(undergraduateStudent.getStudentID());
    }

    @Test
    void getModules() {
        UndergraduateStudent undergraduateStudent = UndergraduateStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.4);
        undergraduateStudent.registerModule("Network1", "1434213874", 20);
        undergraduateStudent.registerModule("Network2", "2341234123", 20);
        System.out.println(undergraduateStudent.getModules());
    }

}