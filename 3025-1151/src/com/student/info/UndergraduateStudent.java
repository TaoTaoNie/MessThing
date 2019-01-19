package com.student.info;

import com.card.info.SmartCard;
import com.card.info.SmartCardNumber;
import com.course.info.Module;

import java.text.ParseException;
import java.util.*;

public class UndergraduateStudent extends Student implements StudentMethod{
    private List<Module> moduleList;
    protected static final Map<StudentID, UndergraduateStudent> STUDENTS = new HashMap<StudentID, UndergraduateStudent>();

    private UndergraduateStudent(String studentName, StudentID id, double passMark) {
        super(studentName, id, passMark);
        this.passMark = 0.4;
        this.moduleList = new ArrayList<Module>();
    }

    public static UndergraduateStudent getInstance(String studentName, StudentID id, double passMark) {
        if (studentName == null || id == null || passMark < 0)
            throw new IllegalArgumentException("Please enter valid parameters");
        if (STUDENTS.containsKey(id))
            return STUDENTS.get(id);
        STUDENTS.put(id, new UndergraduateStudent(studentName, id, passMark));
        return STUDENTS.get(id);
    }

    public void registerModule(String name, String code, int credits) {
        if (name == null || code == null || credits < 0)
            throw new IllegalArgumentException("Please enter valid parameters!");
        this.moduleList.add(Module.getInstance(name, code, credits));
    }

    @Override
    public void setPassMark(double passMark) {
        // the pass mark of undergraduate student must be 0.4
        this.passMark = passMark;
    }

    public int getCredits() {
        Iterator iterator = moduleList.iterator();
        while (iterator.hasNext()) {
            Module module = (Module)iterator.next();
            this.credits += module.getCredits();
        }
        return this.credits;
    }

    @Override
    public void setSmartCard(String studentName, String dateOfBirth, String dateOfIssue, SmartCardNumber smartCardNumber) throws ParseException {
        if (studentName == null || dateOfBirth == null || dateOfIssue == null || smartCardNumber == null)
            throw new IllegalArgumentException("Please enter valid parameters!");
        if (Util.calculateAge(dateOfBirth) < 17)
            throw new IllegalAccessError("Undergraduates younger than 17 cannot issue student CARDS!");
        this.smartCard = SmartCard.getInstance(studentName, dateOfBirth, dateOfIssue, smartCardNumber);
    }

    @Override
    public StudentID getStudentID() {
        return this.id;
    }

    @Override
    public List<Module> getModules() {
        return this.moduleList;
    }

}
