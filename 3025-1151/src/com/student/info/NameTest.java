package com.student.info;

class NameTest {
    @org.junit.jupiter.api.Test
    void getInstance() {
        Name name = Name.getInstance("LeBron","James");
        System.out.println(name.toString());
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        Name name = Name.getInstance("LeBron","James");
        System.out.println(name.getFirstName());
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
        Name name = Name.getInstance("LeBron","James");
        System.out.println(name.getLastName());
    }

    @org.junit.jupiter.api.Test
    void valueOf() {
        Name name = Name.valueOf("LeBron James");
        System.out.println(name.toString());
    }

}