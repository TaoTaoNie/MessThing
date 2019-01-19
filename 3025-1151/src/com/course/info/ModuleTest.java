package com.course.info;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleTest {
    @Test
    void getInstance() {
        Module module = Module.getInstance("Network", "21", 20);
        System.out.println(module.toString());
    }

    @Test
    void valueOf() {
        Module module = Module.valueOf("Programming 2, 2345, 29");
        System.out.println(module.toString());
    }

    @Test
    void getCode() {
        Module module = Module.getInstance("Network", "21", 20);
        System.out.println(module.getCode());
    }

    @Test
    void getName() {
        Module module = Module.getInstance("Network", "21", 20);
        System.out.println(module.getName());
    }

    @Test
    void getCredits() {
        Module module = Module.getInstance("Network", "21", 20);
        System.out.println(module.getCredits());
    }

}