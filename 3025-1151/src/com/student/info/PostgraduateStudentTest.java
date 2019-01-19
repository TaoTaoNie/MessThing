package com.student.info;

import com.card.info.SmartCardNumber;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class PostgraduateStudentTest {
    @Test
    void registerModule() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        postgraduateStudent.registerModule("Network", "1234656", 35);
        System.out.println(postgraduateStudent.getCredits());
    }

    @Test
    void getInstance() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        postgraduateStudent.registerModule("Network", "1234656", 35);
        System.out.println(postgraduateStudent.getCredits());
    }

    @Test
    void setPassMark() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        postgraduateStudent.setPassMark(0.6);
        System.out.println(postgraduateStudent.getPassMark());
    }

    @Test
    void getCredits() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        System.out.println(postgraduateStudent.getCredits());
    }

    @Test
    void getStudentID() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        System.out.println(postgraduateStudent.getStudentID().toString());
    }

    @Test
    void getModules() {
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        postgraduateStudent.registerModule("Network", "1234656", 35);
        System.out.println(postgraduateStudent.getModules());
    }

    @Test
    void setSmartCard() throws ParseException{
        PostgraduateStudent postgraduateStudent = PostgraduateStudent.getInstance("Kobe Bryant", StudentID.valueOf("v1234"), 0.5);
        postgraduateStudent.setSmartCard("Kobe Bryant", "1992-12-26", "2018-5-7", SmartCardNumber.valueOf("KB-2018-12"));
        System.out.println(postgraduateStudent.getSmartCard().toString());
    }

}