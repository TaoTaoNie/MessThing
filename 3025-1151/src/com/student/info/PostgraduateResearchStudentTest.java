package com.student.info;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

class PostgraduateResearchStudentTest {
    @Test
    void setSupervisorName() throws ParseException{
        PostgraduateResearchStudent postgraduateResearchStudent = PostgraduateResearchStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 0.5);
        System.out.println(postgraduateResearchStudent.toString());
        postgraduateResearchStudent.setSupervisorName("Kobe Bryant");
        System.out.println(postgraduateResearchStudent.getSupervisorName());
    }

    @Test
    void getSupervisorName() {
        PostgraduateResearchStudent postgraduateResearchStudent = PostgraduateResearchStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 20.0);
        postgraduateResearchStudent.setSupervisorName("Kobe Bryant");
        System.out.println(postgraduateResearchStudent.getSupervisorName());
    }

    @Test
    void getStudentID() {
        PostgraduateResearchStudent postgraduateResearchStudent = PostgraduateResearchStudent.getInstance("LeBron James", StudentID.valueOf("a1234"), 20.0);
        postgraduateResearchStudent.setSupervisorName("Kobe Bryant");
        System.out.println(postgraduateResearchStudent.getStudentID().toString());
    }


}