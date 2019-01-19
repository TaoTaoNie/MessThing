package com.course.info;

import java.util.HashMap;
import java.util.Map;

public class Module {
    private String name;
    private String code;
    private int credits;

    private static final Map<String, Module> MODULE_MAP = new HashMap<String, Module>();

    private Module(String name, String code, int credits) {
        if (name == null || code == null || credits < 0)
            throw new IllegalArgumentException();
        this.name = name;
        this.code = code;
        this.credits = credits;
    }

    public static Module getInstance(String name, String code, int credits) {
        final String k = name + "," + code + "," + String.valueOf(credits);
        if (!MODULE_MAP.containsKey(k))
            MODULE_MAP.put(k, new Module(name, code, credits));
        return MODULE_MAP.get(k);
    }

    public static Module valueOf(String module) {
        if (MODULE_MAP.containsKey(module))
            return MODULE_MAP.get(module);
        final String[] parts = module.split(",");
        final String name = parts[0].trim();
        final String code = parts[1].trim();
        final int credits = Integer.parseInt(parts[2].trim());

        return new Module(name, code, credits);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.code + ", " + this.credits;
    }
}
