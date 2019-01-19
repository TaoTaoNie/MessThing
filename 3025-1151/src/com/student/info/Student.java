package com.student.info;

import com.card.info.SmartCard;
import com.card.info.SmartCardNumber;

import java.text.ParseException;

public class Student {
    protected Name studentName;
    protected StudentID id;
    protected SmartCard smartCard;
    protected int credits;
    protected double passMark;

    protected Student(String studentName, StudentID id,double passMark) {
        if (studentName == null || id == null || passMark < 0 || passMark > 1)
            throw new IllegalArgumentException("Please enter valid parameters");
        this.studentName = Name.valueOf(studentName);
        this.id = id;
        this.passMark = passMark;
    }

    public Name getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        if (studentName == null)
            throw new IllegalArgumentException("Please enter valid parameters!");
        this.studentName = Name.valueOf(studentName);
    }

    public SmartCard getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(String studentName, String dateOfBirth, String dateOfIssue, SmartCardNumber smartCardNumber) throws ParseException {
        if (studentName == null || dateOfBirth == null || dateOfIssue == null || smartCardNumber == null)
            throw new IllegalArgumentException("Please enter valid parameters!");
        this.smartCard = SmartCard.getInstance(studentName, dateOfBirth, dateOfIssue, smartCardNumber);
    }

    public int getCredits() {
        return credits;
    }

    public double getPassMark() {
        return passMark;
    }

    public void setPassMark(double passMark) {
        if (passMark > 1 || passMark < 0)
            throw new IllegalArgumentException("Please enter valid parameters!");
        this.passMark = passMark;
    }

}
