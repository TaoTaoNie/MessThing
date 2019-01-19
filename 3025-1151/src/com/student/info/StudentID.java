package com.student.info;

import java.util.HashMap;
import java.util.Map;

public class StudentID {
    private String singleLetter;
    private String digitNumber;

    private static final Map<String, StudentID> IDS = new HashMap<String, StudentID>();

    private StudentID(String singleLetter, String digitNumber) {
        if (singleLetter == null || digitNumber == null)
            throw new IllegalArgumentException("Please enter valid parameters!");
        this.singleLetter = singleLetter;
        this.digitNumber = digitNumber;
    }

    public static StudentID getInstance(String singleLetter, String digitNumber) {
        final String k = singleLetter + digitNumber;
        if (!IDS.containsKey(k)) {
            IDS.put(k, new StudentID(singleLetter, digitNumber));
            return IDS.get(k);
        }
        throw new IllegalArgumentException("Students cannot have the same id!");

    }

    public static StudentID valueOf(String studentID) {
        if (IDS.containsKey(studentID))
            throw new IllegalArgumentException("Students cannot have the same id!");
        IDS.put(studentID, new StudentID(studentID.substring(0, 1), studentID.substring(1, 5)));
        return IDS.get(studentID);
    }

    public String getSingleLetter() {return singleLetter;}
    public String getDigitNumber() {return  digitNumber;}

    @Override
    public String toString() {
        return this.singleLetter + this.digitNumber;
    }
}
