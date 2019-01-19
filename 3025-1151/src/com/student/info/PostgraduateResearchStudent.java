package com.student.info;

import java.util.HashMap;
import java.util.Map;

public class PostgraduateResearchStudent extends Student{
    private Name supervisorName;
    protected static final Map<StudentID, PostgraduateResearchStudent> STUDENTS = new HashMap<StudentID, PostgraduateResearchStudent>();

    private PostgraduateResearchStudent(String studentName, StudentID id, double passMark) {
        super(studentName, id, passMark);
    }

    public static PostgraduateResearchStudent getInstance(String studentName, StudentID id, double passMark) {
        if (studentName == null || id == null || passMark < 0)
            throw new IllegalArgumentException("Please enter valid parameters");
        if (STUDENTS.containsKey(id))
            return STUDENTS.get(id);
        STUDENTS.put(id, new PostgraduateResearchStudent(studentName, id, passMark));
        return STUDENTS.get(id);
    }

    public void setSupervisorName(String name) {
        this.supervisorName = Name.valueOf(name);
    }

    public Name getSupervisorName() {
        return supervisorName;
    }

    public StudentID getStudentID() {
        return this.id;
    }
}
