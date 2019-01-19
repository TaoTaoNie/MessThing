package com.student.info;

import java.util.HashMap;
import java.util.Map;

public class Name {
    private String firstName;
    private String lastName;

    private static final Map<String, Name> NAMES= new HashMap<String, Name>();

    private Name(String firstName, String lastName) {
        if (firstName == null || lastName == null)
            throw new IllegalArgumentException();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Name getInstance(String firstName, String lastName) {
        final String k = firstName + " " + lastName;
        if (!NAMES.containsKey(k))
            NAMES.put(k, new Name(firstName, lastName));
        return NAMES.get(k);
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public static Name valueOf(String name) {
        if (NAMES.containsKey(name))
            return NAMES.get(name);
        final String[] parts = name.split(" ");
        final String firstName = parts[0].equals("null") ? null : parts[0];
        final String lastName = parts[1].equals("null") ? null : parts[1];
        return new Name(firstName, lastName);
    }
}
