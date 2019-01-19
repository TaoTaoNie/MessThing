package com.card.info;

import com.student.info.Name;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SmartCard {
    private Name studentName;
    private Date dateOfBirth;
    private SmartCardNumber smartCardNumber;
    private Date dateOfIssue;

    private static final Map<SmartCardNumber, SmartCard> CARDS = new HashMap<SmartCardNumber, SmartCard>();

    private SmartCard (String studentName, String dateOfBirth, String dateOfIssue, SmartCardNumber smartCardNumber) throws ParseException {
        if (studentName == null || dateOfBirth == null || dateOfIssue == null || smartCardNumber == null)
            throw new IllegalArgumentException();
        this.studentName = Name.valueOf(studentName);
        this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
        this.dateOfIssue = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfIssue);
        this.smartCardNumber = smartCardNumber;
    }

    public static SmartCard getInstance(String studentName, String dateOfBirth, String dateOfIssue, SmartCardNumber smartCardNumber) throws ParseException {
        if (!CARDS.containsKey(smartCardNumber))
            CARDS.put(smartCardNumber, new SmartCard(studentName, dateOfBirth, dateOfIssue, smartCardNumber));
        return CARDS.get(smartCardNumber);
    }

    public Name getStudentName() {
        return studentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public SmartCardNumber getSmartCardNumber() {
        return smartCardNumber;
    }

    public Date getDateOfIssue () {
        return dateOfIssue;
    }
}
