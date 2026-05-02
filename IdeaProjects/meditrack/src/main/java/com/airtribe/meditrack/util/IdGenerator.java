package com.airtribe.meditrack.util;

public class IdGenerator {

    private static final IdGenerator instance = new IdGenerator();
    private int id = 1;

    private IdGenerator() {}

    public static IdGenerator getInstance() {
        return instance;
    }

    public int generateId() {
        return id++;
    }
}